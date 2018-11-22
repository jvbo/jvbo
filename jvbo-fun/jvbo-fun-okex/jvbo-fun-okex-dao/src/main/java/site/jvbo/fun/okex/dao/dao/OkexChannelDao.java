package site.jvbo.fun.okex.dao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.jvbo.fun.okex.dao.model.OkexChannel;
import site.jvbo.fun.okex.dao.model.OkexChannelExample;

public interface OkexChannelDao {
    long countByExample(OkexChannelExample example);

    int deleteByExample(OkexChannelExample example);

    int deleteByPrimaryKey(Long channelId);

    int insert(OkexChannel record);

    int insertSelective(OkexChannel record);

    List<OkexChannel> selectByExample(OkexChannelExample example);

    OkexChannel selectByPrimaryKey(Long channelId);

    int updateByExampleSelective(@Param("record") OkexChannel record, @Param("example") OkexChannelExample example);

    int updateByExample(@Param("record") OkexChannel record, @Param("example") OkexChannelExample example);

    int updateByPrimaryKeySelective(OkexChannel record);

    int updateByPrimaryKey(OkexChannel record);
}