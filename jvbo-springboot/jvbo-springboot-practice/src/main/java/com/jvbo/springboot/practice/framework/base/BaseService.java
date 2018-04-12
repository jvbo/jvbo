/*
 * BaseService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jvbo.springboot.practice.framework.mybatis.page.DataGrid;

/**
 * BaseService接口
 * @ClassName: BaseService 
 * @Description: TODO
 * @author jvbo
 * @date 2017年8月29日
 */
public interface BaseService<Record, Example> {

	long countByExample(Example example);

	int deleteByExample(Example example);

	int deleteByPrimaryKey(String id);

	int insert(Record record);

	int insertSelective(Record record);

	List<Record> selectByExampleWithBLOBs(Example example);

	List<Record> selectByExample(Example example);

	List<Record> selectByExampleWithBLOBsForStartPage(Example example, Integer pageNum, Integer pageSize);

	List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize);

	List<Record> selectByExampleWithBLOBsForOffsetPage(Example example, Integer offset, Integer limit);

	List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);
	
	DataGrid<Record> selectByExampleWithBLOBsForStartPageDatagrid(Example example, Integer pageNum, Integer pageSize);

    DataGrid<Record> selectByExampleForStartPageDatagrid(Example example, Integer pageNum, Integer pageSize);

    DataGrid<Record> selectByExampleWithBLOBsForOffsetPageDatagrid(Example example, Integer offset, Integer limit);

    DataGrid<Record> selectByExampleForOffsetPageDatagrid(Example example, Integer offset, Integer limit);

	Record selectFirstByExample(Example example);

	Record selectFirstByExampleWithBLOBs(Example example);

	Record selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

	int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

	int updateByExample(@Param("record") Record record, @Param("example") Example example);

	int updateByPrimaryKeySelective(Record record);

	int updateByPrimaryKeyWithBLOBs(Record record);

	int updateByPrimaryKey(Record record);

	int deleteByPrimaryKeys(String ids);

	void initMapper();

}