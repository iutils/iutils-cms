package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Category;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 栏目表 DAO接口
 * 
 * @author MyCode
 * @version 1.0
 */
@MyBatisDao
public interface CategoryDao extends ICrudDao<Category> {

	/**
	 * 获取网站栏目
	 * 
	 * @param siteId
	 * @return
	 */
	public List<Category> findListBySiteId(@Param("siteId") String siteId);

}
