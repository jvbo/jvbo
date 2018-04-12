/*
 * MySQLPaginationPlugin.java 2016年10月15日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import com.jvbo.springboot.practice.framework.util.PropertiesFileUtil;

/**
 * MySQLPaginationPlugin
 * @ClassName: MySQLPaginationPlugin 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月15日
 */
public class MySQLPaginationPlugin extends PluginAdapter {
    
    private static final String pageClassFullName;
    private static final String pageName;
    private static final String pageIndexName;
    private static final String pageSizeName;
    
    static {
        PropertiesFileUtil properties = PropertiesFileUtil.getInstance("mybatis-generator");
        pageClassFullName = properties.get("mybatis.generator.plugins.page.class-full-name");
        pageName = properties.get("mybatis.generator.plugins.page.name");
        pageIndexName = properties.get("mybatis.generator.plugins.page.pageIndex-name");
        pageSizeName = properties.get("mybatis.generator.plugins.page.pageSize-name");
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause
        addPage(topLevelClass, introspectedTable, pageName);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }
 
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        XmlElement page = new XmlElement("if");
        page.addAttribute(new Attribute("test", pageName + " != null"));//page != null
        page.addElement(new TextElement(new StringBuilder().append("limit #{")
                .append(pageIndexName).append("} , #{"+pageSizeName).append("}").toString()));// limit 0,10
        element.addElement(page);
 
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }
 
    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,
            String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType(pageClassFullName));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType(pageClassFullName));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(pageClassFullName), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(pageClassFullName));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }
 
    public boolean validate(List<String> warnings) {
        return true;
    }

}
