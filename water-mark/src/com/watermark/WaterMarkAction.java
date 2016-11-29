package com.watermark;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WaterMarkAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private File image;
	private String imageFileName;
	private String uploadPath; //文件上传的相对路径
	
	private PicInfo picInfo = new PicInfo();
	
	private MarkService markService = new TestMarkService();
	
	private MarkService imageMarkService = new ImageMarkService();
	
	public String watermark() throws Exception{
		
		//通过相对路径获取绝对路径
		String realUploadPath = ServletActionContext.getServletContext().getRealPath(uploadPath);
		
//		UploadService UploadService = new UploadService();
		
//		UploadService.uploadImage(image, imageFileName, uploadPath, realUploadPath);
		
//		markService.waterMark(image, imageFileName, uploadPath, realUploadPath);
		
//		picInfo.setImageURL(UploadService.uploadImage(image, imageFileName, uploadPath, realUploadPath));
		
		picInfo.setImageURL(imageMarkService.waterMark(image, imageFileName, uploadPath, realUploadPath));
		
		return SUCCESS;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public PicInfo getPicInfo() {
		return picInfo;
	}

	public void setPicInfo(PicInfo picInfo) {
		this.picInfo = picInfo;
	}
	
	
}
