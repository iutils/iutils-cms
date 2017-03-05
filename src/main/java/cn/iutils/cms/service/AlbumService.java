package cn.iutils.cms.service;

import cn.iutils.cms.dao.AlbumDao;
import cn.iutils.cms.entity.Album;
import cn.iutils.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 相册表 Service层
* @author MyCode
* @version 1.0
*/
@Service
@Transactional(readOnly = true)
public class AlbumService extends CrudService<AlbumDao, Album> {

    /**
     * 获取指定的相册大小
     * @param categoryId
     * @param size
     * @return
     */
    public List<Album> findSize(String categoryId,int size){
        return dao.findSize(categoryId,size);
    }

}
