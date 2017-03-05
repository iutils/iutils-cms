package cn.iutils.cms.service;

import cn.iutils.cms.dao.SiteDao;
import cn.iutils.cms.entity.Site;
import cn.iutils.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 站点表 Service层
 * 
 * @author MyCode
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SiteService extends CrudService<SiteDao, Site> {

    /**
     * 获取默认站点
     * @return
     */
    public Site getDefault(){
        return dao.getDefault();
    }

    /**
     * 设置默认网站
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public int setDefault(String id){
        dao.restore();
        return dao.setDefault(id);
    }

}
