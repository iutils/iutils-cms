package cn.iutils.cms.service;

import cn.iutils.cms.dao.CommodityDao;
import cn.iutils.cms.entity.Commodity;
import cn.iutils.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 商品表 Service层
* @author MyCode
* @version 1.0
*/
@Service
@Transactional(readOnly = true)
public class CommodityService extends CrudService<CommodityDao, Commodity> {

    /**
     * 获取指定的商品列表
     * @param categoryId
     * @param size
     * @return
     */
    public List<Commodity> findSize(String categoryId,int size){
        return dao.findSize(categoryId,size);
    }

}
