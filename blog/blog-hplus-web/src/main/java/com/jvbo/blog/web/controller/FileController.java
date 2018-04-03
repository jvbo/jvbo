/*
 * FileController.java 2016年11月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.jvbo.blog.framework.constant.Constants;
import com.jvbo.framework.utils.qiniu.QiniuUtils;

@Controller
@RequestMapping("/file")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "/config")
	public void uploadConfig(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String newRootPath = rootPath+ "\\STATIC\\js\\ueditor1_4_3-utf8-jsp\\jsp";
		try {
			String exec = new ActionEnter(request, newRootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/qiniuUploadImgFile")
	public Map<String,Object> qiniuUploadImgFile(@RequestParam(value = "upfile", required = false) MultipartFile[] upfile) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if (upfile != null && upfile.length > 0){
			//循环获取file数组中得文件
			for(int i = 0;i<upfile.length;i++){
				MultipartFile file = upfile[i];
				String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).toLowerCase();// 取文件格式后缀名并转为小写
				if(file.getSize()>0.5*1024*1024){
					map.put("state","上传文件不能大于500k!");
				} else if(StringUtils.containsAny(type,Constants.imgType)){
					map.put("state","只能上传.jpg,.jpeg,.gif,.png,.bmp结尾的文件!");
				}else{
					String fileName = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
					byte[] fileByte = file.getBytes();
					//返回对象
					System.out.println("上传文件"+fileName);
					try {
						new QiniuUtils().uploadFile(fileByte,fileName);
						map.put("url",fileName);
						map.put("name",fileName);
						map.put("state","SUCCESS");
					}catch (Exception e){
						e.printStackTrace();
						map.put("state","上传失败!");
					}
				}
			}
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/springMvcUploadImgFile")
	public Map<String, Object> springMvcUploadImgFile(@RequestParam(value="uploadfile",required = false) CommonsMultipartFile file, HttpServletRequest request){
		boolean flag=false;
		String mark="0";
		if (!file.isEmpty()) {
			String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
			String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
			String path = request.getSession().getServletContext().getRealPath(Constants.upload + filename);// 存放位置
			File destFile = new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
				mark="1";
			} catch (Exception e) {
				logger.error("springMvcUploadImgFile上传文件异常:{},详情:{}", new Object[]{e.getMessage(), e});
			}
		}
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		viewMap.put("mark", mark);
		return viewMap;
	}

	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/commonUploadImgFile")
	public Map<String, Object> commonUploadImgFile(HttpServletRequest request,HttpSession session){
		boolean flag=false;
		String mark="0";
		try{
			String savePath = session.getServletContext().getRealPath("/")+Constants.upload;
			File file=new File(savePath);
			if(!file.exists()||!file.isDirectory()){
				file.mkdir();
			}
			//使用Apache文件上传组件处理文件上传步骤
			//1.创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//2、创建一个文件上传解析器
			ServletFileUpload upload=new ServletFileUpload(factory);
			//设置编码
			upload.setHeaderEncoding("utf-8");
			//3、判断提交上来的数据是否是上传表单的数据
			if(!ServletFileUpload.isMultipartContent(request)){
				mark="-1";
			}else{
				//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表
				List<FileItem> list = upload.parseRequest(request);
				for(FileItem item : list){
					if(!item.isFormField()){
						//得到上传的文件名称，
						String filename=item.getName();
						if(filename==null || filename.trim().equals("")){
							continue;
						}
						//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
						filename = filename.substring(filename.lastIndexOf("\\")+1);
						//获取item中的上传文件的输入流
						InputStream in = item.getInputStream();
						//创建一个文件输出流
						FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
						//创建一个缓冲区
						byte buffer[] = new byte[in.available()];
						//判断输入流中的数据是否已经读完的标识
						int len = 0;
						//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
						while((len=in.read(buffer))>0){
							//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
							out.write(buffer, 0, len);
						}
						in.close();
						out.close();
						item.delete();
						mark="1";
					}
				}
			}
		}catch(Exception e){
			logger.error("commonUploadImgFile上传文件异常:{},详情:{}", new Object[]{e.getMessage(), e});
		}finally{
			Map<String, Object> viewMap = new HashMap<String, Object>();
			viewMap.put("success", flag);
			viewMap.put("mark", mark);
			return viewMap;
		}
	}
}
