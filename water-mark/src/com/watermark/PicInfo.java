package com.watermark;

public class PicInfo {
	
	//图片的访问路径
	private String imageURL;
	
	//添加了水印的图片的访问路径
	private String logoImageURL;
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLogoImageURL() {
		return logoImageURL;
	}
	public void setLogoImageURL(String logoImageURL) {
		this.logoImageURL = logoImageURL;
	}
	
}
