package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

/**
 * 站点表
 * 
 * @author MyCode
 * @version 1.0
 */
public class Site extends DataEntity<Site> {

	private static final long serialVersionUID = 1L;

	private String name;// 站点名称
	private String logo;// 站点Logo
	private String icon;// 站点小图标
	private String domain;// 站点域名
	private String description;// 描述
	private String keywords;// 关键字
	private String copyright;// 版权信息
	private String theme;// 主题
	private Boolean isDefault = Boolean.FALSE;// 是否默认站点

	public Site() {
		super();
	}

	public Site(String id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
}
