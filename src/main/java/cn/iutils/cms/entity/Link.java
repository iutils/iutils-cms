package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

/**
 * 链接表
 * @author MyCode
 * @version 1.0
 */
public class Link extends DataEntity<Link> {

	private static final long serialVersionUID = 1L;
	
	private String categoryId;//栏目编号
	private String title;//链接名称
	private String image;//链接图片
	private String href;//链接地址
	
	public Link() {
		super();
	}
	public Link(String id){
		super(id);
	}
	
	public String getCategoryId(){
		return categoryId;
	}
	
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
	
	public String getHref(){
		return href;
	}
	
	public void setHref(String href){
		this.href = href;
	}
	
}
