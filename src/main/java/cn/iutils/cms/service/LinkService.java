package cn.iutils.cms.service;

import cn.iutils.cms.dao.LinkDao;
import cn.iutils.cms.entity.Link;
import cn.iutils.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 链接表 Service层
* @author MyCode
* @version 1.0
*/
@Service
@Transactional(readOnly = true)
public class LinkService extends CrudService<LinkDao, Link> {

    /**
     * 获取指定的链接列表
     * @param categoryId
     * @param userId
     * @param size
     * @return
     */
    public List<Link> findSize(String categoryId,String userId,int size){
        return dao.findSize(categoryId,userId,size);
    }

}
