package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

/**
 * 文章详表
 * @author MyCode
 * @version 1.0
 */
public class ArticleData extends DataEntity<ArticleData> {

	private static final long serialVersionUID = 1L;
	
	private String articleId;//文章编号
	private String content;//文章内容
	private String copyfrom = "程序员工具";//文章来源
	private Boolean allowComment=Boolean.FALSE;//是否允许评论
	
	public ArticleData() {
		super();
	}
	public ArticleData(String id){
		super(id);
	}
	
	public String getArticleId(){
		return articleId;
	}
	
	public void setArticleId(String articleId){
		this.articleId = articleId;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getCopyfrom(){
		return copyfrom;
	}
	
	public void setCopyfrom(String copyfrom){
		this.copyfrom = copyfrom;
	}

	public Boolean getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Boolean allowComment) {
		this.allowComment = allowComment;
	}
}
