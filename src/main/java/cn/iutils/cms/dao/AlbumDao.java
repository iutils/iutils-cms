package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Album;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 相册表 DAO接口
* @author MyCode
* @version 1.0
*/
@MyBatisDao
public interface AlbumDao extends ICrudDao<Album> {

    /**
     * 获取指定的相册大小
     * @param categoryId
     * @param size
     * @return
     */
    public List<Album> findSize(@Param("categoryId") String categoryId, @Param("size") int size);

}
