package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Link;
import cn.iutils.cms.service.LinkService;
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
 * 链接表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/link")
public class LinkController extends BaseController {

	@Autowired
	private LinkService linkService;

	@ModelAttribute
	public Link get(@RequestParam(required = false) String id) {
		Link entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = linkService.get(id);
		}
		if (entity == null) {
			entity = new Link();
		}
		return entity;
	}

	@RequiresPermissions("cms:link:view")
	@RequestMapping(value = "/list")
	public String list(Link link, Model model, Page<Link> page) {
		page.setEntity(link);
		model.addAttribute("page", page.setList(linkService.findPage(page)));
		return "cms/link/list";
	}

	@RequiresPermissions("cms:link:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Link link, Model model) {
		model.addAttribute("link", link);
		return "cms/link/form";
	}

	@RequiresPermissions("cms:link:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Link link, RedirectAttributes redirectAttributes) {
		linkService.save(link);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/link/update?id="+link.getId();
	}

	@RequiresPermissions("cms:link:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Link link, Model model) {
		model.addAttribute("link", link);
		return "cms/link/form";
	}

	@RequiresPermissions("cms:link:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Link link, RedirectAttributes redirectAttributes) {
		linkService.save(link);
		addMessage(redirectAttributes, "修改成功");
		return "redirect:" + adminPath + "/cms/link/update?id="+link.getId();
	}

	@RequiresPermissions("cms:link:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Link link,int pageNo,int pageSize,
			RedirectAttributes redirectAttributes) {
		linkService.delete(link);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/link/list?categoryId="+link.getCategoryId()+"&pageNo="+pageNo+"&pageSize="+pageSize;
	}

}
