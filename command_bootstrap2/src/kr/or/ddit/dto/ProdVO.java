package kr.or.ddit.dto;

import java.util.Date;

public class ProdVO {

	private int code    ;
	private String name    ;
	private String price   ;
	private String detail  ;
	private int qty     ;
	private String delivery;
	private String deliveryprice;
	private Date deliverydate ;
	private String img          ;
	private String detailimg    ;
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getDeliveryprice() {
		return deliveryprice;
	}
	public void setDeliveryprice(String deliveryprice) {
		this.deliveryprice = deliveryprice;
	}
	public Date getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDetailimg() {
		return detailimg;
	}
	public void setDetailimg(String detailimg) {
		this.detailimg = detailimg;
	}
	
		
		
}
