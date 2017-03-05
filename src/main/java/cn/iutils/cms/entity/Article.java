package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

/**
 * 文章表
 * 
 * @author MyCode
 * @version 1.0
 */
public class Article extends DataEntity<Article> {

	private static final long serialVersionUID = 1L;

	private String categoryId;// 栏目编号
	private String title;// 标题
	private String link;// 文章链接
	private String image;// 文章图片
	private int hits;// 点击数
	private String keywords;// 关键字
	private String description;// 摘要
	private ArticleData articleData;//文章内容

	//仅用于查询
	private String[] categoryIds;
	private Category category;//栏目

	public Article() {
		super();
	}

	public Article(String id) {
		super(id);
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArticleData getArticleData() {
		return articleData;
	}

	public void setArticleData(ArticleData articleData) {
		this.articleData = articleData;
	}

	public String[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String[] categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
