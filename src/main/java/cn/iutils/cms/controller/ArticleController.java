package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Article;
import cn.iutils.cms.entity.ArticleData;
import cn.iutils.cms.service.ArticleDataService;
import cn.iutils.cms.service.ArticleService;
import cn.iutils.common.Page;
import cn.iutils.common.controller.BaseController;
import cn.iutils.common.utils.JStringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 文章表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/article")
public class ArticleController extends BaseController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleDataService articleDataService;

	@ModelAttribute
	public Article get(@RequestParam(required = false) String id) {
		Article entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = articleService.get(id);
		}
		if (entity == null) {
			entity = new Article();
		}
		return entity;
	}

	@RequiresPermissions("cms:article:view")
	@RequestMapping(value = "/list")
	public String list(Article article, Model model, Page<Article> page) {
		page.setEntity(article);
		model.addAttribute("page", page.setList(articleService.findPage(page)));
		return "cms/article/list";
	}

	@RequiresPermissions("cms:article:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Article article,Model model) {
		model.addAttribute("article", article);
		return "cms/article/form";
	}

	@RequiresPermissions("cms:article:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional
	public String create(Article article, ArticleData articleData,
			RedirectAttributes redirectAttributes) {
		articleService.save(article);
		articleData.setId(article.getId());
		articleDataService.insert(articleData);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/article/update?id="+article.getId();
	}

	@RequiresPermissions("cms:article:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Article article, Model model) {
		model.addAttribute("article", article);
		return "cms/article/form";
	}

	@RequiresPermissions("cms:article:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@Transactional
	public String update(Article article, ArticleData articleData,
			RedirectAttributes redirectAttributes) {
		articleService.save(article);
		articleDataService.save(articleData);
		addMessage(redirectAttributes, "编辑成功");
		return "redirect:" + adminPath + "/cms/article/update?id="+article.getId();
	}

	@RequiresPermissions("cms:article:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@Transactional
	public String delete(Article article,int pageNo,int pageSize,
			RedirectAttributes redirectAttributes) {
		articleService.delete(article);
		articleDataService.delete(article.getId());
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/article/list?categoryId="+article.getCategoryId()+"&pageNo="+pageNo+"&pageSize="+pageSize;
	}

}
