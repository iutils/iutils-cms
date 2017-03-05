package cn.iutils.cms.entity;

import cn.iutils.sys.entity.DataEntity;

import java.util.Date;

/**
 * 商品表
 * 
 * @author MyCode
 * @version 1.0
 */
public class Commodity extends DataEntity<Commodity> {

	private static final long serialVersionUID = 1L;

	private String categoryId;// 栏目编号
	private String sn;// 商品货号
	private String name;// 商品名称
	private String brandId;// 品牌编号
	private String img;// 商品图片
	private float price;// 商品价格
	private float market;// 市场价格
	private int amount;// 商品库存
	private Date time;// 上架时间
	private Date marketime;// 上市时间
	private String colour;// 商品颜色
	private Boolean isShop=Boolean.FALSE;// 是否上架
	private Boolean isRec=Boolean.FALSE;// 是否推荐
	private int count;// 购买次数
	private Boolean isNew=Boolean.FALSE;// 是否新品
	private Boolean isHot=Boolean.FALSE;// 是否热卖
	private int sort;// 排序
	private String description;// 商品描述

	public Commodity() {
		super();
	}

	public Commodity(String id) {
		super(id);
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getMarket() {
		return market;
	}

	public void setMarket(float market) {
		this.market = market;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getMarketime() {
		return marketime;
	}

	public void setMarketime(Date marketime) {
		this.marketime = marketime;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Boolean getIsShop() {
		return isShop;
	}

	public void setIsShop(Boolean isShop) {
		this.isShop = isShop;
	}

	public Boolean getIsRec() {
		return isRec;
	}

	public void setIsRec(Boolean isRec) {
		this.isRec = isRec;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
