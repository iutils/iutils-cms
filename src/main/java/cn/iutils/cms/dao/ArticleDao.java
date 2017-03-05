package cn.iutils.cms.dao;

import cn.iutils.cms.entity.Article;
import cn.iutils.common.ICrudDao;
import cn.iutils.common.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章表 DAO接口
 * 
 * @author MyCode
 * @version 1.0
 */
@MyBatisDao
public interface ArticleDao extends ICrudDao<Article> {

	/**
	 * 访问加1
	 * 
	 * @param id
	 * @return
	 */
	public int updateHitsAddOne(@Param("id") String id);

	/**
	 * 获取指定的文章列表
	 * @param categoryId
	 * @param size
	 * @return
	 */
	public List<Article> findSize(@Param("categoryId") String categoryId, @Param("size") int size);
}
