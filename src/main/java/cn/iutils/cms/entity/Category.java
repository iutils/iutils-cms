package cn.iutils.cms.entity;

import cn.iutils.cms.entity.enums.ModuleEnum;
import cn.iutils.sys.entity.DataEntity;

/**
 * 栏目表
 * 
 * @author MyCode
 * @version 1.0
 */
public class Category extends DataEntity<Category> {

	private static final long serialVersionUID = 1L;

	private String siteId;// 站点编号
	private String parentId;// 父级编号
	private String name;// 栏目名称
	private ModuleEnum module = ModuleEnum.nav;// 模块类型
	private int sort;// 排序（升序）
	private String href;// 访问地址
	private Boolean showHome = Boolean.FALSE;// 是否首页显示
	private Boolean isBy = Boolean.FALSE;//是否有下级导航
	private String customView;//自定义视图

	public Category() {
		super();
	}

	public Category(String id) {
		super(id);
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModuleEnum getModule() {
		return module;
	}

	public void setModule(ModuleEnum module) {
		this.module = module;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getShowHome() {
		return showHome;
	}

	public void setShowHome(Boolean showHome) {
		this.showHome = showHome;
	}

	public Boolean getIsBy() {
		return isBy;
	}

	public void setIsBy(Boolean isBy) {
		this.isBy = isBy;
	}

	public String getCustomView() {
		return customView;
	}

	public void setCustomView(String customView) {
		this.customView = customView;
	}
}
