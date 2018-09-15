package site.jvbo.fun.common.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class MybatisGeneratorUtil {

	// generatorConfig模板路径
	private static String generatorConfig_vm = "/template/generator-config.vm";
	// Service模板路径
	private static String service_vm = "/template/Service.vm";
	// ServiceImpl模板路径
	private static String serviceImpl_vm = "/template/ServiceImpl.vm";

	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbc_driver   驱动路径
	 * @param jdbc_url      链接
	 * @param jdbc_username 帐号
	 * @param jdbc_password 密码
	 * @param module        项目模块
	 * @param database      数据库
	 * @param table_prefix  表前缀
	 * @param package_name  包名
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
    public static void generator(
			String jdbc_driver,
			String jdbc_url,
			String jdbc_username,
			String jdbc_password,
			String module,
			String database,
			String table_prefix,
			String package_name,
			String mapper_xml,
			Map<String, String> last_insert_id_tables) throws Exception{

		String os = System.getProperty("os.name");
		String targetProject = module + "/" + module + "-dao";
		String basePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/test-classes/", "").replace(targetProject, "");
		if (os.toLowerCase().startsWith("win")) {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
		} else {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
		}

		String generatorConfigXml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/test-classes/", "") + "/src/main/resources/generator-config.xml";
		targetProject = basePath + targetProject;
		String sqlTable = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + database + "' AND table_name LIKE '" + table_prefix + "%';";
		System.out.println("========== 开始生成generator-config.xml文件 ==========");
		List<Map<String, Object>> tables = new ArrayList<>();
		JdbcUtil jdbcUtil = null;
		try {
			VelocityContext context = new VelocityContext();
			Map<String, Object> table;

			// 查询定制前缀项目的所有表
			jdbcUtil = new JdbcUtil(jdbc_driver, jdbc_url, jdbc_username, jdbc_password);
			List<Map> tableResult = jdbcUtil.selectByParams(sqlTable, null);
			for (Map map : tableResult) {
				System.out.println(map.get("TABLE_NAME"));
				table = new HashMap<>();
				String tableName = ObjectUtils.toString(map.get("TABLE_NAME"), null);
				String modelName = StringUtil.lineToHump(ObjectUtils.toString(tableName));
				table.put("table_name", tableName);
				table.put("model_name", modelName);
				table.put("mapper_name", modelName + "Dao");
		        String sqlColumn = "SELECT COLUMN_NAME,DATA_TYPE,COLUMN_KEY FROM INFORMATION_SCHEMA. COLUMNS WHERE table_schema = '" + database + "' AND table_name = '" + tableName + "';";
	            List<Map> columnResult = jdbcUtil.selectByParams(sqlColumn, null);
	            List<Map> columns = new ArrayList<>();
	            Map<String, Object> column;
	            for (Map map2 : columnResult) {
	                column = new HashMap<>();
	                String columnName = ObjectUtils.toString(map2.get("COLUMN_NAME"), null);
                    column.put("column_name", columnName);
                    column.put("data_type", ObjectUtils.toString(map2.get("DATA_TYPE"), null).toUpperCase());
	                columns.add(column);
	                if("PRI".equalsIgnoreCase(ObjectUtils.toString(map2.get("COLUMN_KEY")))){
	                    last_insert_id_tables.put(tableName, columnName);
	                }
                }
	            table.put("columns", columns);
		        tables.add(table);
			}

			context.put("tables", tables);
			context.put("generator_javaModelGenerator_targetPackage", package_name + ".dao.model");
			context.put("generator_sqlMapGenerator_targetPackage", mapper_xml);
			context.put("generator_javaClientGenerator_targetPackage", package_name + ".dao.dao");
			context.put("targetProject", targetProject);
			context.put("targetProject_sqlMap", targetProject);
			context.put("last_insert_id_tables", last_insert_id_tables);
			VelocityUtil.generate(generatorConfig_vm, generatorConfigXml, context);
			// 删除旧代码
			deleteDir(new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/model"));
			deleteDir(new File(targetProject + "/src/main/resources/" + mapper_xml));
			deleteDir(new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/dao"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            jdbcUtil.release();
		}
		System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

		System.out.println("========== 开始运行MybatisGenerator ==========");
		List<String> warnings = new ArrayList<>();
		File configFile = new File(generatorConfigXml);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("========== 结束运行MybatisGenerator ==========");

		System.out.println("========== 开始生成Service ==========");
		String date = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath + module + "/" + module + "-service" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service";
		String serviceImplPath = basePath + module + "/" + module + "-service" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service/impl";
		for (int i = 0; i < tables.size(); i++) {
			String model_name = ObjectUtils.toString(tables.get(i).get("model_name"));
            String service_name = "I" + model_name + "Service";
            String service_impl_name = model_name + "ServiceImpl";
			String service = servicePath + "/" + service_name + ".java";
			String serviceImpl = serviceImplPath + "/" + service_impl_name + ".java";
			// 生成service
			File serviceFile = new File(service);
			if (!serviceFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", package_name);
				context.put("model_name", model_name);
                context.put("service_name", service_name);
				context.put("date", date);
				VelocityUtil.generate(service_vm, service, context);
				System.out.println(service);
			}
			// 生成serviceImpl
			File serviceImplFile = new File(serviceImpl);
			if (!serviceImplFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", package_name);
				context.put("model_name", model_name);
                context.put("service_name", service_name);
                context.put("service_impl_name", service_impl_name);
				context.put("mapper_name", StringUtil.toLowerCaseFirstOne(model_name));
				context.put("date", date);
				VelocityUtil.generate(serviceImpl_vm, serviceImpl, context);
				System.out.println(serviceImpl);
			}
		}
		System.out.println("========== 结束生成Service ==========");
	}

	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}

}
