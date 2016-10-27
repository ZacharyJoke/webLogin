package com.webapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.util.CardUtil;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify") 
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getSession().getId();
		if (CardUtil.users.containsKey(uid)) {
			if (CardUtil.users.get(uid)) {
				//��½�ɹ��󷵻�һ��true
				response.getWriter().println("var obj={result:true}");
			}else{
				//��½ʧ�ܺ󷵻�һ��false
				response.getWriter().println("var obj={result:false}");
			}
		}
		}

}
