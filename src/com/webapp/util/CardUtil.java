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
 * @Description:��ά�����ɵĹ�����
 * @author ZacharyJoke
 *
 */
public class CardUtil {	
	
	public static void main(String[] args) {
		
	}
	public static HashMap<String, Boolean> users = new HashMap<String, Boolean>();
	public static BufferedImage getQrcodeImage(String content){
		Qrcode qrcode = new Qrcode();
		//���ñ���ģʽΪbyte
		qrcode.setQrcodeEncodeMode('B');
		//���þ������ݴ�30%
		qrcode.setQrcodeErrorCorrect('M');
		//���ð汾��
		qrcode.setQrcodeVersion(15);
		//������ת���ɶ�ά������ݡ��Ұ��㡱
		byte[] bytes = content.getBytes();//���ַ���ת�����ֽ�����
		//boolean���͵Ķ�ά���� 0 1 false true ��ά��ĸ�ʽ����
		boolean[][] results = qrcode.calQrcode(bytes);
		//����Щ��ά���ݲ�����ͼƬ
		int width =235;
		//��ɫ��ԭɫ red green blue
		BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
		//ͨ��ͼƬ�õ���ͼ����
		Graphics2D grap = image.createGraphics();
		//��ά�룩�׵׺ڿ�ķ���
		//���ñ�����ɫΪ��ɫ
		grap.setBackground(Color.WHITE);
		grap.clearRect(0, 0, width, width);
		//���û��ʵ���ɫΪ��ɫ
		grap.setColor(Color.BLACK);
		//������ά����	
		for (int y = 0; y < results.length; y++) {
			for (int x = 0; x < results.length; x++) {
				if(results[x][y]){
					//��ͼ�������һ����ɫ����
					grap.fillRect(x*3, y*3, 3, 3);
				}
			}
		}
		try {
		ImageIO.write(image, "jpeg", new File("c:\\Users\\ZacharyJoke\\Desktop\\���ɵĶ�ά��.jpg"));
	} catch (Exception e) {
		e.printStackTrace();
	}
		return image;

	}
}
