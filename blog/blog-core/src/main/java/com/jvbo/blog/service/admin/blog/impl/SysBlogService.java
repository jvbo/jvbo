/*
 * BlogService.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: BlogService.java
 * @Package com.jvbo.blog.service.admin.blog.impl
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.service.admin.blog.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.dao.admin.BlogMapper;
import com.jvbo.blog.dao.admin.SysBlogBlogTypeMapper;
import com.jvbo.blog.framework.lucene.BlogIndex;
import com.jvbo.blog.model.Blog;
import com.jvbo.blog.model.BlogExample;
import com.jvbo.blog.model.SysBlogBlogType;
import com.jvbo.blog.service.admin.blog.ISysBlogService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;

/**  
 * @ClassName: BlogService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
@Service
public class SysBlogService implements ISysBlogService{

	@Autowired
	private BlogMapper blogDao;
	@Autowired
	private SysBlogBlogTypeMapper blogBlogTypeDao;

	//博客索引(lucene)
	private BlogIndex blogIndex = new BlogIndex();

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean save(BlogBo record) {
		boolean flag = false;
		try {
			Blog blog = new Blog();
			BeanUtils.copyProperties(record, blog);
			flag = blogDao.insertSelective(blog)>0;
			if(flag){
				blogIndex.addIndex(record); // 添加博客索引
			}
		} catch (Exception e) {
			flag = false;
			throw new RuntimeException();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} 
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(BlogBo record) {
		boolean flag = false;
		try {
			Blog blog = new Blog();
			BeanUtils.copyProperties(record, blog);
			flag = blogDao.updateByPrimaryKeySelective(blog)>0;
			if(flag){
				blogIndex.updateIndex(record);// 更新博客索引
			}
		} catch (Exception e) {
			flag = false;
			throw new RuntimeException();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} 
		return flag;
	}

	@Override
	public SysBlogBlogType findById(String id) {
		return blogBlogTypeDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean batchDel(String[] ids) {
		boolean flag = false;
		try {
			for (String string : ids) {
				flag = blogDao.deleteByPrimaryKey(string)>0;
				if(!flag){
					break;
				}else{
					blogIndex.deleteIndex(string);// 删除对应博客的索引
				}
			}
		} catch (Exception e) {
			flag = false;
			throw new RuntimeException();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} 
		return flag;
	}

	@Override
	public long count(String title) {
		BlogExample example = new BlogExample();
		BlogExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleEqualTo(title);
		}
		return blogBlogTypeDao.countByExample(example);
	}

	@Override
	/*public List<BlogBo> list(String title, Page page) {
		BlogExample example = new BlogExample();
		BlogExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleEqualTo(title);
		}
		page.setTotalRecords(Long.valueOf(count(title)).intValue());
		example.setPage(page);
		List<Blog> blogList = blogDao.selectByExample(example);
		List<BlogBo> blogBoList = new ArrayList<BlogBo>();

		CollectionUtils.collect(blogList,new Transformer() {
			@Override
			public Object transform(Object input) {
				Blog blog = (Blog)input;
				BlogBo blogBo = new BlogBo();
				BeanUtils.copyProperties(blog, blogBo);
				return blogBo;
			}
		},blogBoList);
		for (int i = 0; i < blogList.size(); i++) {
			BlogType blogType = blogTypeService.findById(blogList.get(i).getId());
			blogBoList.get(i).setBlogType(blogType);
		}
		return blogBoList;
	}*/

	public DataGrid<SysBlogBlogType> list(String title, Page page) {
		BlogExample example = new BlogExample();
		BlogExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("1");
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleEqualTo(title);
		}
		page.setTotalRecords(Long.valueOf(count(title)).intValue());
		example.setPage(page);
		
		List<SysBlogBlogType> blogList = blogBlogTypeDao.selectByExample(example);
		DataGrid<SysBlogBlogType> dg = new DataGrid<SysBlogBlogType>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(blogList);
		dg.setPage(page.getPage());
		return dg;
	}

}
