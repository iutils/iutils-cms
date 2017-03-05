package cn.iutils.cms.service;

import cn.iutils.cms.dao.ArticleDataDao;
import cn.iutils.cms.entity.ArticleData;
import cn.iutils.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章详表 Service层
 * 
 * @author MyCode
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends
		CrudService<ArticleDataDao, ArticleData> {

	/**
	 * 新增文章内容
	 *
	 * @param articleData
	 * @return
	 */
	@Transactional(readOnly = false)
	public int insert(ArticleData articleData) {
		return dao.insert(articleData);
	}

}
