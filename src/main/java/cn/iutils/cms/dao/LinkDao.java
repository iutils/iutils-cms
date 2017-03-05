package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Link;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 链接表 DAO接口
* @author MyCode
* @version 1.0
*/
@MyBatisDao
public interface LinkDao extends ICrudDao<Link> {

    /**
     * 获取指定的链接列表
     * @param categoryId
     * @param userId
     * @param size
     * @return
     */
    public List<Link> findSize(@Param("categoryId") String categoryId, @Param("userId") String userId, @Param("size") int size);

}
