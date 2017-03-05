package cn.iutils.cms.controller;

import cn.iutils.cms.entity.*;
import cn.iutils.cms.entity.enums.ModuleEnum;
import cn.iutils.cms.service.*;
import cn.iutils.common.Page;
import cn.iutils.common.controller.BaseController;
import cn.iutils.common.utils.JStringUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.List;

/**
 * 网站访问接口
 *
 * @author iutils.cn
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class FrontController extends BaseController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDataService articleDataService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private CommodityService commodityService;

    @ModelAttribute
    public Site get(@RequestParam(required = false) String id) {
        Site entity = null;
        if (JStringUtils.isNotBlank(id)) {
            entity = siteService.get(id);
        }
        if (entity == null) {
            //获取默认站点
            entity = siteService.getDefault();
        }
        return entity;
    }

    /**
     * 访问主页
     * @param site
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Site site, Model model) {
        // 获取网站信息
        model.addAttribute("site", site);
        return "cms/theme/" + site.getTheme() + "/index";
    }

    /**
     * 用户个人中心
     * @return
     */
    @RequestMapping(value = "/personal${urlSuffix}", method = RequestMethod.GET)
    public String personal(Site site,Model model){
        // 获取网站信息
        model.addAttribute("site", site);
        return "cms/theme/" + site.getTheme() + "/personal";
    }

    /**
     * 访问导航
     *
     * @param site 站点
     * @param navId  导航ID
     * @param model
     * @return
     */
    @RequestMapping(value = "/{navId}/nav${urlSuffix}", method = RequestMethod.GET)
    public String nav(Site site,
                      @PathVariable("navId") String navId, @RequestParam(required = false) String categoryId, Model model) {
        common(site, navId, categoryId, model);
        if (JStringUtils.isNotBlank(categoryId)) {
            model.addAttribute("categorys", Lists.newArrayList(categoryService.get(categoryId)));
        }
        return "cms/theme/" + site.getTheme() + "/nav";
    }

    /**
     * 访问自定义视图
     * @return
     */
    @RequestMapping(value = "/{navId}/view/{view}${urlSuffix}", method = RequestMethod.GET)
    public String customView(Site site,
                             @PathVariable("navId") String navId, @PathVariable("view") String view, @RequestParam(required = false) String categoryId, Model model) {
        common(site, navId, categoryId, model);
        if (JStringUtils.isNotBlank(categoryId)) {
            model.addAttribute("categorys", Lists.newArrayList(categoryService.get(categoryId)));
        }
        return "cms/theme/" + site.getTheme() + "/" + view;
    }

    /**
     * 分享文章
     * @param site
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{navId}/{categoryId}/share${urlSuffix}", method = RequestMethod.GET)
    public String share(Site site, @PathVariable("navId") String navId, @PathVariable("categoryId") String categoryId, Model model) {
        common(site, navId, categoryId, model);
        return "cms/theme/" + site.getTheme() + "/share";
    }

    /**
     * 查询文章
     * @param site
     * @param model
     * @return
     */
    @RequestMapping(value = "/{navId}/search${urlSuffix}", method = RequestMethod.GET)
    public String search(Site site, @PathVariable("navId") String navId,Page<Article> page,Model model) throws Exception {
        common(site, navId, null, model);
        String key = new String(page.getKey().getBytes("iso-8859-1"),"utf-8");
        page.setKey(key);
        model.addAttribute("page", page.setList(articleService.findPage(page)));
        return "cms/theme/" + site.getTheme() + "/search";
    }

    /**
     * 访问详情内容页面
     *
     * @param site    网站
     * @param articleId 内容ID
     * @return
     */
    @RequestMapping(value = "/{siteId}/{navId}/{articleId}/detail${urlSuffix}", method = RequestMethod.GET)
    public String detail(Site site, @PathVariable("navId") String navId, @PathVariable("categoryId") String categoryId,
                         @PathVariable("articleId") String articleId, Model model) {
        common(site, navId, categoryId, model);
        // 获取详细内容
        Article article = articleService.get(articleId);
        model.addAttribute("article", article);
        ArticleData articleData = articleDataService.get(articleId);
        model.addAttribute("articleData", articleData);
        // 访问＋1
        articleService.updateHitsAddOne(articleId);
        // 获取网站主题
        return "cms/theme/" + site.getTheme() + "/detail";
    }

    /**
     * 初始化公共方法
     * @param site
     * @param navId
     * @param categoryId
     */
    public void common(Site site,String navId, String categoryId, Model model) {
        model.addAttribute("site", site);
        model.addAttribute("category", categoryService.get(navId));
        Category category = new Category();
        category.setParentId(navId);
        model.addAttribute("categoryNexts", categoryService.findList(category));
        model.addAttribute("categoryId", categoryId);
    }
}
