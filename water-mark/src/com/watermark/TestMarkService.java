package com.watermark;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class TestMarkService implements MarkService {

	/**
	 * 为图片添加单个水印
	 */
	@Override
	public String waterMark(File image, String imageFileName, String uploadPath, String realUploadPath) {

		String logoFileName = "logo" + imageFileName;
		OutputStream os = null;
		
		try{
			
			Image image2 = ImageIO.read(image);
			int width = image2.getWidth(null);
			int height = image2.getHeight(null);
			
			//1.创建图片缓存对象
			BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			
			//2.创建java绘图工具对象
			Graphics2D g = bufferedImage.createGraphics();
			
			//3.使用绘图工具对象将原图绘制到缓存图片对象
			g.drawImage(image2, 0, 0, width, height, null);
			
			g.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
			g.setColor(FONT_CLOUR);
			
			int width1 = FONT_SIZE*this.getTestLength(MARk_TEXT);
			int height1 = FONT_SIZE;
			
			int widthDiff = width - width1;
			int heightDiff = height - height1;
			
			int x = X;
			int y = Y;
			
			if(x>widthDiff){
				x = widthDiff;
			}
			
			if(y>heightDiff){
				y = heightDiff;
			}
			
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
			
			g.drawString(MARk_TEXT, x, y+FONT_SIZE);
			
			g.dispose();
			
			os = new FileOutputStream(realUploadPath + "/" + logoFileName);
			
			//创建图像编码工具类
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			
			//使用图像编码工具类 属兔缓存图像到目标文件
			en.encode(bufferedImage);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return uploadPath + "/" + logoFileName;
	}
	
	public int getTestLength(String text){
		
		int length = text.length();
		
		for(int i = 0; i<text.length(); i++){
			String s = String.valueOf(text.charAt(i));
			if(s.getBytes().length>1){
				length++;
			}
		}
		
		length = length%2==0?length/2:length/2+1;
		return length;
	}
	

}
