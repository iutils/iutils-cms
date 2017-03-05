package cn.iutils.cms.taglib;

import cn.iutils.cms.entity.*;
import cn.iutils.cms.entity.enums.ModuleEnum;
import cn.iutils.cms.service.*;
import cn.iutils.common.Page;
import cn.iutils.common.spring.SpringUtils;

import java.util.List;

/**
 * 建站系统 库方法
 * @author iutils.cn
 */
public class CmsLib {

    /**
     * 站点
     */
    private static SiteService siteService = SpringUtils.getBean(SiteService.class);

    /**
     * 栏目
     */
    private static CategoryService categoryService = SpringUtils.getBean(CategoryService.class);

    /**
     * 文章
     */
    private static ArticleService articleService = SpringUtils.getBean(ArticleService.class);

    /**
     * 相册
     */
    private static AlbumService albumService = SpringUtils.getBean(AlbumService.class);

    /**
     * 链接
     */
    private static LinkService linkService = SpringUtils.getBean(LinkService.class);

    /**
     * 商品
     */
    private static CommodityService commodityService = SpringUtils.getBean(CommodityService.class);

    /**
     * 随机样式
     */
    private static String[] css = {"primary","secondary","success","warning","danger",""};

    /**
     * 获取站点信息
     * @param siteId
     * @return
     */
    public static Site getSite(String siteId) {
        return siteService.get(siteId);
    }

    /**
     * 查询站点的所有栏目导航
     * @param siteId 站点编号
     * @return
     */
    public static List<Category> getNav(String siteId){
        Category category = new Category();
        category.setSiteId(siteId);
        category.setModule(ModuleEnum.nav);
        return categoryService.findList(category);
    }

    /**
     * 查询栏目下的导航
     * @param siteId 站点编号
     * @param categoryId 栏目编号
     * @return
     */
    public static List<Category> getNavBy(String siteId,String categoryId){
        Category category = new Category();
        category.setSiteId(siteId);
        category.setParentId(categoryId);
        return categoryService.findList(category);
    }

    /**
     * 获取栏目下的模块
     * @param categoryId
     * @return
     */
    public static List<Category> getNavListBy(String categoryId){
        Category category = new Category();
        category.setParentId(categoryId);
        category.setModule(null);
        return categoryService.findList(category);
    }

    /**
     * 获取分类下 文章的数量
     * @param categoryId
     * @return
     */
    public static int getCategoryArticleCount(String categoryId){
        Article article = new Article();
        article.setCategoryId(categoryId);
        Page<Article> page = new Page<Article>();
        page.setEntity(article);
        return articleService.count(page);
    }

    /**
     * 获取分页文章
     * @param categorys
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static Page<Article> getArticlePage(List<Category> categorys,int pageNo,int pageSize){
        Page<Article> page = new Page<Article>();
        page.setPageNo(pageNo<0?0:pageNo);
        page.setPageSize(pageSize<10?10:pageSize);
        Article article = new Article();
        String[] categoryIds = new String[categorys.size()];
        for (int i=0;i<categorys.size();i++){
            categoryIds[i] = categorys.get(i).getId();
        }
        article.setCategoryIds(categoryIds);
        page.setEntity(article);
        return page.setList(articleService.findPage(page));
    }

    /**
     * 获取文章前n条
     * @param categoryId
     * @param size
     * @return
     */
    public static List<Article> getArticleList(String categoryId,int size){
        return articleService.findSize(categoryId, size);
    }

    /**
     * 获取文章内容
     * @param id
     * @return
     */
    public static Article getArticle(String id){
        return articleService.get(id);
    }

    /**
     * 获取相册前n条
     * @param categoryId
     * @param size
     * @return
     */
    public static List<Album> getAlbumList(String categoryId,int size){
        return albumService.findSize(categoryId, size);
    }

    /**
     * 获取链接前n条
     * @param categoryId
     * @param size
     * @return
     */
    public static List<Link> getLinkList(String categoryId,String userId,int size){
        return linkService.findSize(categoryId, userId,size);
    }

    /**
     * 获取商品前n条
     * @param categoryId
     * @param size
     * @return
     */
    public static List<Commodity> getCommodityList(String categoryId,int size){
        return commodityService.findSize(categoryId, size);
    }

    /**
     * 随机样式
     * @return
     */
    public static String randomCss(){
        return css[(int)(Math.random()*5)+1];
    }

}
