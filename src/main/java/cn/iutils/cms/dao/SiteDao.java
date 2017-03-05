package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Site;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

/**
 * 站点表 DAO接口
 * 
 * @author MyCode
 * @version 1.0
 */
@MyBatisDao
public interface SiteDao extends ICrudDao<Site> {

    /**
     * 获取默认站点
     * @return
     */
    public Site getDefault();

    /**
     * 恢复
     * @return
     */
    public int restore();

    /**
     * 设置默认网站
     * @param id
     * @return
     */
    public int setDefault(@Param("id")String id);

}
