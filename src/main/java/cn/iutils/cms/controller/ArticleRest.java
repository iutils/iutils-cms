package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Article;
import cn.iutils.cms.entity.ArticleData;
import cn.iutils.cms.service.ArticleDataService;
import cn.iutils.cms.service.ArticleService;
import cn.iutils.common.ResultVo;
import cn.iutils.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章分享 接口
 * @author iutils.cn
 * @version 1.0
 */
@RestController
@RequestMapping("${restPath}/article")
public class ArticleRest extends BaseController{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDataService articleDataService;

    /**
     * 提交文章
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public @ResponseBody
    ResultVo submit(Article article, ArticleData articleData){
        ResultVo resultVo = null;
        try{
            articleService.save(article);
            articleData.setId(article.getId());
            articleDataService.insert(articleData);
            resultVo = new ResultVo(ResultVo.SUCCESS,"1","调用成功",null);
        }catch (Exception e){
            logger.error("文章分享接口调用失败",e.getMessage());
            resultVo = new ResultVo(ResultVo.FAILURE,"-1","调用失败",null);
        }
        return resultVo;
    }

}
