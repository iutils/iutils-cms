package cn.iutils.cms.controller;

import cn.iutils.cms.entity.Album;
import cn.iutils.cms.service.AlbumService;
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
 * 相册表 控制器
 * 
 * @author MyCode
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/cms/album")
public class AlbumController extends BaseController {

	@Autowired
	private AlbumService albumService;

	@ModelAttribute
	public Album get(@RequestParam(required = false) String id) {
		Album entity = null;
		if (JStringUtils.isNotBlank(id)) {
			entity = albumService.get(id);
		}
		if (entity == null) {
			entity = new Album();
		}
		return entity;
	}

	@RequiresPermissions("cms:album:view")
	@RequestMapping(value = "/list")
	public String list(Album album, Model model, Page<Album> page) {
		page.setEntity(album);
		model.addAttribute("page", page.setList(albumService.findPage(page)));
		return "cms/album/list";
	}

	@RequiresPermissions("cms:album:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Album album, Model model) {
		model.addAttribute("album", album);
		return "cms/album/form";
	}

	@RequiresPermissions("cms:album:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Album album, RedirectAttributes redirectAttributes) {
		albumService.save(album);
		addMessage(redirectAttributes, "新增成功");
		return "redirect:" + adminPath + "/cms/album/update?id="+album.getId();
	}

	@RequiresPermissions("cms:album:update")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Album album, Model model) {
		model.addAttribute("album", album);
		return "cms/album/form";
	}

	@RequiresPermissions("cms:album:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Album album, RedirectAttributes redirectAttributes) {
		albumService.save(album);
		addMessage(redirectAttributes, "修改成功");
		return "redirect:" + adminPath + "/cms/album/update?id="+album.getId();
	}

	@RequiresPermissions("cms:album:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Album album,int pageNo,int pageSize,RedirectAttributes redirectAttributes) {
		albumService.delete(album);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/cms/album/list?categoryId="+album.getCategoryId()+"&pageNo="+pageNo+"&pageSize="+pageSize;
	}

}
