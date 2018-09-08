package site.jvbo.fun.upms.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.upms.dao.model.UserOrganization;
import site.jvbo.fun.upms.dao.model.UserOrganizationExample;

public interface UserOrganizationDao {
    long countByExample(UserOrganizationExample example);

    int deleteByExample(UserOrganizationExample example);

    int deleteByPrimaryKey(Long userOrganizationId);

    int insert(UserOrganization record);

    int insertSelective(UserOrganization record);

    List<UserOrganization> selectByExample(UserOrganizationExample example);

    UserOrganization selectByPrimaryKey(Long userOrganizationId);

    int updateByExampleSelective(@Param("record") UserOrganization record, @Param("example") UserOrganizationExample example);

    int updateByExample(@Param("record") UserOrganization record, @Param("example") UserOrganizationExample example);

    int updateByPrimaryKeySelective(UserOrganization record);

    int updateByPrimaryKey(UserOrganization record);
}