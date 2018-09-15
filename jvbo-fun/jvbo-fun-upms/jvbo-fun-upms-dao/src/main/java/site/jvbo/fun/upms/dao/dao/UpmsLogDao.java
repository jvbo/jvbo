package site.jvbo.fun.upms.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.upms.dao.model.UpmsLog;
import site.jvbo.fun.upms.dao.model.UpmsLogExample;

public interface UpmsLogDao {
    long countByExample(UpmsLogExample example);

    int deleteByExample(UpmsLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(UpmsLog record);

    int insertSelective(UpmsLog record);

    List<UpmsLog> selectByExample(UpmsLogExample example);

    UpmsLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByExample(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByPrimaryKeySelective(UpmsLog record);

    int updateByPrimaryKey(UpmsLog record);
}