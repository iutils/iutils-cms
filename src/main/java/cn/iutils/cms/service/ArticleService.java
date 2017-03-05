package cn.iutils.cms.service;

import cn.iutils.cms.dao.ArticleDao;
import cn.iutils.cms.entity.Article;
import cn.iutils.common.service.CrudService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章表 Service层
 * 
 * @author MyCode
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class ArticleService extends CrudService<ArticleDao, Article> {

	/**
	 * 访问加1
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public int updateHitsAddOne(String id) {
		return dao.updateHitsAddOne(id);
	}

	/**
	 * 获取指定的文章列表
	 * @param categoryId
	 * @param size
	 * @return
	 */
	public List<Article> findSize(String categoryId,int size){
		return dao.findSize(categoryId, size);
	}

}
