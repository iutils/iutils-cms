package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Site;
import cn.iutils.cms.service.CategoryService;
import cn.iutils.cms.service.SiteService;
import cn.iutils.common.Page;
import cn.iutils.common.ResultVo;
import cn.iutils.common.controller.BaseController;
import cn.iutils.common.utils.JStringUtils;
import cn.iutils.common.utils.UserUtils;
import cn.iutils.sys.entity.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * 站点表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/site")
public class SiteController extends BaseController {

	@Autowired
	private SiteService siteService;

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute
	public Site get(@RequestParam(required = false) String id) {
		Site entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = siteService.get(id);
		}
		if (entity == null) {
			entity = new Site();
		}
		return entity;
	}

	@RequiresPermissions("cms:site:view")
	@RequestMapping()
	public String list(Site site,Model model, Page<Site> page) {
		site.setUser(UserUtils.getLoginUser());
		page.setEntity(site);
		model.addAttribute("page", page.setList(siteService.findPage(page)));
		return "cms/site/list";
	}

	@RequiresPermissions("cms:site:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Site site,Model model) {
		model.addAttribute("site", site);
		return "cms/site/form";
	}

	@RequiresPermissions("cms:site:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Site site, RedirectAttributes redirectAttributes) {
		siteService.save(site);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/site/update?id="+site.getId();
	}

	@RequiresPermissions("cms:site:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Site site, Model model) {
		model.addAttribute("site", site);
		return "cms/site/form";
	}

	@RequiresPermissions("cms:site:create")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Site site, RedirectAttributes redirectAttributes) {
		siteService.save(site);
		addMessage(redirectAttributes, "修改成功");
		return "redirect:" + adminPath + "/cms/site/update?id="+site.getId();
	}

	@RequiresPermissions("cms:site:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id,int pageNo,int pageSize,
			RedirectAttributes redirectAttributes) {
		siteService.delete(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/site?pageNo="+pageNo+"&pageSize="+pageSize;
	}

	/**
	 * 设置默认网站
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("cms:site:default")
	@RequestMapping(value = "/{id}/default", method = RequestMethod.GET)
	public String setDefault(@PathVariable("id") String id,int pageNo,int pageSize,
							 RedirectAttributes redirectAttributes){
		siteService.setDefault(id);
		addMessage(redirectAttributes, "设置成功");
		return "redirect:" + adminPath + "/cms/site?pageNo="+pageNo+"&pageSize="+pageSize;
	}

	/**
	 * 网站建设
	 * @return
	 */
	@RequiresPermissions("cms:site:build")
	@RequestMapping(value = "/build", method = RequestMethod.GET)
	public String build(Site site, Model model) {
		model.addAttribute("categoryList", categoryService.findListBySiteId(site.getId()));
		model.addAttribute("site", site);
		return "cms/site/build";
	}

}
