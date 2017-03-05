package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Commodity;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 商品表 DAO接口
* @author MyCode
* @version 1.0
*/
@MyBatisDao
public interface CommodityDao extends ICrudDao<Commodity> {

    /**
     * 获取指定的商品列表
     * @param categoryId
     * @param size
     * @return
     */
    public List<Commodity> findSize(@Param("categoryId") String categoryId, @Param("size") int size);

}
