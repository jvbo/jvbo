package site.jvbo.fun.upms.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.upms.dao.model.UpmsPermission;
import site.jvbo.fun.upms.dao.model.UpmsPermissionExample;

public interface UpmsPermissionDao {
    long countByExample(UpmsPermissionExample example);

    int deleteByExample(UpmsPermissionExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(UpmsPermission record);

    int insertSelective(UpmsPermission record);

    List<UpmsPermission> selectByExample(UpmsPermissionExample example);

    UpmsPermission selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") UpmsPermission record, @Param("example") UpmsPermissionExample example);

    int updateByExample(@Param("record") UpmsPermission record, @Param("example") UpmsPermissionExample example);

    int updateByPrimaryKeySelective(UpmsPermission record);

    int updateByPrimaryKey(UpmsPermission record);
}