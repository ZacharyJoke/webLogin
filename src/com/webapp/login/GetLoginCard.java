package com.webapp.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.util.CardUtil;

/**
 * Servlet implementation class GetLoginCard
 */
@WebServlet("/GetLoginCard")
public class GetLoginCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CardUtil.users.put(request.getSession().getId(),false);
//		String info="���";
		
		String url="http://169.254.76.63:8080/webLogin/DoLogin?uid="+request.getSession().getId();
		BufferedImage image = CardUtil.getQrcodeImage(url);
		//������ӦͷβͼƬ����
		response.setContentType("image/jpeg");
		//�õ���Ӧ�������
		OutputStream out = response.getOutputStream();
		//ͨ��ImageIO �����responsede����Ӧ��
		ImageIO.write(image, "jpeg", out);
	}

}
