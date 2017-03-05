package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Category;
import cn.iutils.cms.entity.enums.ModuleEnum;
import cn.iutils.cms.service.CategoryService;
import cn.iutils.cms.service.SiteService;
import cn.iutils.common.Page;
import cn.iutils.common.controller.BaseController;
import cn.iutils.common.utils.JStringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 栏目表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/category")
public class CategoryController extends BaseController {

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute
	public Category get(@RequestParam(required = false) String id) {
		Category entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = categoryService.get(id);
		}
		if (entity == null) {
			entity = new Category();
		}
		return entity;
	}

	@ModelAttribute("modules")
	public ModuleEnum[] modules() {
		return ModuleEnum.values();
	}

	@RequiresPermissions("cms:category:view")
	@RequestMapping(value = "/list")
	public String list(Category category, Model model, Page<Category> page) {
		page.setEntity(category);
		page.setOrderBy("a.sort");
		model.addAttribute("page", page.setList(categoryService.findPage(page)));
		return "cms/category/list";
	}

	@RequiresPermissions("cms:category:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Category category, Model model) {
		model.addAttribute("category", category);
		return "cms/category/form";
	}

	@RequiresPermissions("cms:category:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Category category,
			RedirectAttributes redirectAttributes) {
		categoryService.save(category);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/category/update?id="+category.getId();
	}

	@RequiresPermissions("cms:category:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Category category,Model model) {
		model.addAttribute("category", category);
		return "cms/category/form";
	}

	@RequiresPermissions("cms:category:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Category category,
			RedirectAttributes redirectAttributes) {
		categoryService.save(category);
		addMessage(redirectAttributes, "修改成功");
		return "redirect:" + adminPath + "/cms/category/update?id="+category.getId();
	}

	@RequiresPermissions("cms:category:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Category category,int pageNo,int pageSize,
			RedirectAttributes redirectAttributes) {
		categoryService.delete(category);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/category/list?siteId="+category.getSiteId()+"&parentId="+category.getParentId()+"&pageNo="+pageNo+"&pageSize="+pageSize;
	}

}
