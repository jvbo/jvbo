package site.jvbo.fun.upms.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.upms.dao.model.Organization;
import site.jvbo.fun.upms.dao.model.OrganizationExample;

public interface OrganizationDao {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Long organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Long organizationId);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}