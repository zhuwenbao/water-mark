package com.watermark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class UploadService {
	
	/**
	 * 
	 * @param image 上传图片
	 * @param imageFilename 上传图片的名称
	 * @param uploadPath  上传的相对路径 访问上传后的图片信息
	 * @param realUploadPath 上传的绝对路径 指定上传的图片保存在哪个子目录下
	 * @return
	 */
	public String uploadImage(File image,String imageFilename,String uploadPath,String realUploadPath){
		
		InputStream is =null;
		OutputStream os = null;
		
		try{
			
			is = new FileInputStream(image);
			os = new FileOutputStream(realUploadPath+"/"+imageFilename);
			
			byte[] buffer = new byte[1024];
			int len =0;
			
			while((len = is.read(buffer))>0){
				os.write(buffer);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return uploadPath + "/" + imageFilename;
	}
}
