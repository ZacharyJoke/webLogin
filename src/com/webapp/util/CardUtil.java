package com.webapp.util;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;
/**
 * @ClassName:CardUtil
 * @Description:二维码生成的工具类
 * @author ZacharyJoke
 *
 */
public class CardUtil {	
	
	public static void main(String[] args) {
		
	}
	public static HashMap<String, Boolean> users = new HashMap<String, Boolean>();
	public static BufferedImage getQrcodeImage(String content){
		Qrcode qrcode = new Qrcode();
		//设置编码模式为byte
		qrcode.setQrcodeEncodeMode('B');
		//设置纠错级别（容错）30%
		qrcode.setQrcodeErrorCorrect('M');
		//设置版本号
		qrcode.setQrcodeVersion(15);
		//将内容转换成二维码的数据“我爱你”
		byte[] bytes = content.getBytes();//将字符串转换成字节数组
		//boolean类型的二维数组 0 1 false true 二维码的格式数据
		boolean[][] results = qrcode.calQrcode(bytes);
		//把这些二维数据产生成图片
		int width =235;
		//颜色三原色 red green blue
		BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
		//通过图片拿到画图工具
		Graphics2D grap = image.createGraphics();
		//二维码）白底黑块的方块
		//设置背景颜色为白色
		grap.setBackground(Color.WHITE);
		grap.clearRect(0, 0, width, width);
		//设置画笔的颜色为黑色
		grap.setColor(Color.BLACK);
		//遍历二维数组	
		for (int y = 0; y < results.length; y++) {
			for (int x = 0; x < results.length; x++) {
				if(results[x][y]){
					//画图工具填充一个黑色方块
					grap.fillRect(x*3, y*3, 3, 3);
				}
			}
		}
		try {
		ImageIO.write(image, "jpeg", new File("c:\\Users\\ZacharyJoke\\Desktop\\生成的二维码.jpg"));
	} catch (Exception e) {
		e.printStackTrace();
	}
		return image;

	}
}
