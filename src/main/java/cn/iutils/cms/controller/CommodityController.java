package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Commodity;
import cn.iutils.cms.service.CommodityService;
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
 * 商品表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/commodity")
public class CommodityController extends BaseController {

	@Autowired
	private CommodityService commodityService;

	@ModelAttribute
	public Commodity get(@RequestParam(required = false) String id) {
		Commodity entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = commodityService.get(id);
		}
		if (entity == null) {
			entity = new Commodity();
		}
		return entity;
	}

	@RequiresPermissions("cms:commodity:view")
	@RequestMapping(value = "/list")
	public String list(Commodity commodity, Model model, Page<Commodity> page) {
		page.setEntity(commodity);
		model.addAttribute("page",
				page.setList(commodityService.findPage(page)));
		return "cms/commodity/list";
	}

	@RequiresPermissions("cms:commodity:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Commodity commodity, Model model) {
		model.addAttribute("commodity", commodity);
		return "cms/commodity/form";
	}

	@RequiresPermissions("cms:commodity:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Commodity commodity,
			RedirectAttributes redirectAttributes) {
		commodityService.save(commodity);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/commodity/update?id="+commodity.getId();
	}

	@RequiresPermissions("cms:commodity:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Commodity commodity, Model model) {
		model.addAttribute("commodity", commodity);
		return "cms/commodity/form";
	}

	@RequiresPermissions("cms:commodity:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Commodity commodity,
			RedirectAttributes redirectAttributes) {
		commodityService.save(commodity);
		addMessage(redirectAttributes, "修改成功");
		return "redirect:" + adminPath + "/cms/commodity/update?id="+commodity.getId();
	}

	@RequiresPermissions("cms:commodity:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Commodity commodity,int pageNo,int pageSize,
			RedirectAttributes redirectAttributes) {
		commodityService.delete(commodity);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/commodity/list?categoryId="+commodity.getCategoryId()+"&pageNo="+pageNo+"&pageSize="+pageSize;
	}

}
