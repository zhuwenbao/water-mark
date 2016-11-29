package com.watermark;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

/**
 * 
 */
public interface MarkService {

	//添加文字的水印内容
	public static final String MARk_TEXT = "i love you";
	
	//字体名称
	public static final String FONT_NAME = "微软雅黑";
	
	//文字的样式
	public static final int FONT_STYLE = Font.BOLD;
	
	//文字的大小
	public static final int FONT_SIZE = 50;
	
	//文字的颜色
	public static final Color FONT_CLOUR = Color.BLACK;
	
	//水印的位置
	public static final int X= 10;
	public static final int Y = 10;
	
	//透明化处理
	public static float  ALPHA = 0.3F; 
	
	public static final String LOGO = "weibo.png";
	
	public String waterMark(File image,String imageFilename,String uploadPath,String realUploadPath);
}
