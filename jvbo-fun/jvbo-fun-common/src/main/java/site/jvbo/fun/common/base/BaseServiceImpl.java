/*
 * BaseServiceImpl.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.common.mybatis.page.DataGrid;
import site.jvbo.fun.common.util.SpringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 实现BaseService抽象类
 * @ClassName: BaseService 
 * @Description: TODO
 * @author jvbo
 * @date 2017年8月29日
 */
public abstract class BaseServiceImpl<DaoMapper, Record, Example> implements BaseService<Record, Example> {

	public DaoMapper mapper;

	@Override
	public long countByExample(Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("countByExample", example.getClass());
			Object result = countByExample.invoke(mapper, example);
			return Long.parseLong(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	public int deleteByExample(Example example) {
		try {
			Method deleteByExample = mapper.getClass().getDeclaredMethod("deleteByExample", example.getClass());
			Object result = deleteByExample.invoke(mapper, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		try {
			Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
			Object result = deleteByPrimaryKey.invoke(mapper, id);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insert(Record record) {
		try {
			Method insert = mapper.getClass().getDeclaredMethod("insert", record.getClass());
			Object result = insert.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertSelective(Record record) {
		try {
			Method insertSelective = mapper.getClass().getDeclaredMethod("insertSelective", record.getClass());
			Object result = insertSelective.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExampleWithBLOBs(Example example) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			Object result = selectByExampleWithBLOBs.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExample(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExampleWithBLOBsForStartPage(Example example, Integer pageNum, Integer pageSize) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			PageHelper.startPage(pageNum, pageSize, false);
			Object result = selectByExampleWithBLOBs.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			PageHelper.startPage(pageNum, pageSize, false);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExampleWithBLOBsForOffsetPage(Example example, Integer offset, Integer limit) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			PageHelper.offsetPage(offset, limit, false);
			Object result = selectByExampleWithBLOBs.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			PageHelper.offsetPage(offset, limit, false);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    @Override
    public DataGrid<Record> selectByExampleWithBLOBsForStartPageDatagrid(Example example, Integer pageNum, Integer pageSize) {
        DataGrid<Record> dg = new DataGrid<>();
	    try {
            Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
            Page<Record> page = PageHelper.startPage(pageNum, pageSize, true);
            selectByExampleWithBLOBs.invoke(mapper, example);
            dg.setTotal(page.getTotal());
            dg.setPage(page.getPageNum());
            dg.setPages(page.getPages());
            dg.setRows(page.getResult());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return dg;
    }

    @Override
    public DataGrid<Record> selectByExampleForStartPageDatagrid(Example example, Integer pageNum, Integer pageSize) {
        DataGrid<Record> dg = new DataGrid<>();
        try {
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
            Page<Record> page = PageHelper.startPage(pageNum, pageSize, true);
            selectByExample.invoke(mapper, example);
            dg.setTotal(page.getTotal());
            dg.setPage(page.getPageNum());
            dg.setPages(page.getPages());
            dg.setRows(page.getResult());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return dg;
    }

    @Override
    public DataGrid<Record> selectByExampleWithBLOBsForOffsetPageDatagrid(Example example, Integer offset, Integer limit) {
        DataGrid<Record> dg = new DataGrid<>();
        try {
            Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
            Page<Record> page = PageHelper.offsetPage(offset, limit, true);
            selectByExampleWithBLOBs.invoke(mapper, example);
            dg.setTotal(page.getTotal());
            dg.setPage(page.getPageNum());
            dg.setPages(page.getPages());
            dg.setRows(page.getResult());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return dg;
    }

    @Override
    public DataGrid<Record> selectByExampleForOffsetPageDatagrid(Example example, Integer offset, Integer limit) {
        DataGrid<Record> dg = new DataGrid<>();
        try {
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
            Page<Record> page = PageHelper.offsetPage(offset, limit, true);
            selectByExample.invoke(mapper, example);
            dg.setTotal(page.getTotal());
            dg.setPage(page.getPageNum());
            dg.setPages(page.getPages());
            dg.setRows(page.getResult());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return dg;
    }

	@SuppressWarnings("unchecked")
    @Override
	public Record selectFirstByExample(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			List<Record> result = (List<Record>) selectByExample.invoke(mapper, example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public Record selectFirstByExampleWithBLOBs(Example example) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			List<Record> result = (List<Record>) selectByExampleWithBLOBs.invoke(mapper, example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public Record selectByPrimaryKey(Long id) {
		try {
			Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
			Object result = selectByPrimaryKey.invoke(mapper, id);
			return (Record) result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
		try {
			Method updateByExampleSelective = mapper.getClass().getDeclaredMethod("updateByExampleSelective", record.getClass(), example.getClass());
			Object result = updateByExampleSelective.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example) {
		try {
			Method updateByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("updateByExampleWithBLOBs", record.getClass(), example.getClass());
			Object result = updateByExampleWithBLOBs.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
		try {
			Method updateByExample = mapper.getClass().getDeclaredMethod("updateByExample", record.getClass(), example.getClass());
			Object result = updateByExample.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateByPrimaryKeySelective(Record record) {
		try {
			Method updateByPrimaryKeySelective = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", record.getClass());
			Object result = updateByPrimaryKeySelective.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateByPrimaryKeyWithBLOBs(Record record) {
		try {
			Method updateByPrimaryKeyWithBLOBs = mapper.getClass().getDeclaredMethod("updateByPrimaryKeyWithBLOBs", record.getClass());
			Object result = updateByPrimaryKeyWithBLOBs.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateByPrimaryKey(Record record) {
		try {
			Method updateByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKey", record.getClass());
			Object result = updateByPrimaryKey.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteByPrimaryKeys(String ids) {
		try {
			if (StringUtils.isBlank(ids)) {
				return 0;
			}
			String[] idArray = ids.split("-");
			int count = 0;
			for (String idStr : idArray) {
				if (StringUtils.isBlank(idStr)) {
					continue;
				}
				Integer id = Integer.parseInt(idStr);
				Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
				Object result = deleteByPrimaryKey.invoke(mapper, id);
				count += Integer.parseInt(String.valueOf(result));
			}
			return count;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void initDaoMapper() {
		this.mapper = SpringUtils.getBean(getDaoMapperClass());
	}

	/**
	 * 获取类泛型class
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public Class<DaoMapper> getDaoMapperClass() {
		return (Class<DaoMapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}