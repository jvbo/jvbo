/*
 * BlogService.java 2016年10月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: BlogService.java
 * @Package com.jvbo.blog.service.blog
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
package com.jvbo.blog.service.front.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.bo.BlogArchiveBo;
import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.dao.front.FrontBlogMapper;

/**  
 * @ClassName: BlogService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月20日
 */
@Service
public class FrontBlogService implements IFrontBlogService {
	
	@Autowired
	private FrontBlogMapper blogDao;
	
	@Override
	public List<BlogBo> countList() {
		return blogDao.countList();
	}

	@Override
	public List<BlogBo> list(Map<String, Object> map) {
		return blogDao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}

	@Override
	public BlogBo findById(String id) {
		return blogDao.findById(id);
	}
	
	public Integer update(BlogBo blog){
		return blogDao.update(blog);
	}
	
	@Override
	public BlogBo getLastBlog(String id) {
		return blogDao.getLastBlog(id);
	}

	@Override
	public BlogBo getNextBlog(String id) {
		return blogDao.getNextBlog(id);
	}

	@Override
	public Integer getBlogCountByTypeId(String typeId) {
		return blogDao.getBlogByTypeId(typeId);
	}

	@Override
	public List<BlogBo> newBlogList() {
		return blogDao.newBlogList();
	}

	@Override
	public List<BlogArchiveBo> archives() {
		List<BlogBo> blogBoList = blogDao.list(new HashMap<String, Object>());
		List<BlogArchiveBo> blogArchiveBoList = blogDao.findBlogYearAndNum();
		for (BlogArchiveBo blogArchiveBo : blogArchiveBoList) {
			List<BlogBo> handleBlogBoList = new ArrayList<BlogBo>();
			for (BlogBo blogBo : blogBoList) {
				Integer comYear = Integer.parseInt(DateUtils.format(blogBo.getAddTime(), "yyyy"));
				if(blogArchiveBo.getYear().intValue()==comYear.intValue()){
					handleBlogBoList.add(blogBo);
				}
			}
			blogArchiveBo.setBlogBoList(handleBlogBoList);;
		}
		return blogArchiveBoList;
	}

}
