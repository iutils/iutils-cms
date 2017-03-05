package cn.iutils.cms.service;

import cn.iutils.cms.dao.CategoryDao;
import cn.iutils.cms.entity.Category;
import cn.iutils.common.service.CrudService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 栏目表 Service层
 * 
 * @author MyCode
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class CategoryService extends CrudService<CategoryDao, Category> {

	/**
	 * 获取网站栏目
	 * 
	 * @param siteId
	 * @return
	 */
	public List<Category> findListBySiteId(String siteId) {
		return dao.findListBySiteId(siteId);
	}

}
