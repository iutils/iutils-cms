package cn.iutils.cms.entity.enums;

/**
 * 模块类型
 * 
 * @author cc
 * 
 */
public enum ModuleEnum {

	nav("导航栏"), article("文章模型"), link("链接模型"), album("相册模型"), commodity("商品模型");

	private final String info;

	private ModuleEnum(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
