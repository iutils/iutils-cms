package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

/**
 * 相册表
 * @author MyCode
 * @version 1.0
 */
public class Album extends DataEntity<Album> {

	private static final long serialVersionUID = 1L;
	
	private String categoryId;//栏目编号
	private String title;//标题
	private String image;//图片地址
	
	public Album() {
		super();
	}
	public Album(String id){
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
	
}
