package com.webapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.util.CardUtil;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		if (CardUtil.users.containsKey(uid)) {
			CardUtil.users.put(uid, true);
			//登陆成功，给用户打印 Login Success
			response.getWriter().println("Login Success");
		}else{
			//登陆失败，给用户打印 Login Fail
			response.getWriter().println("Login Fail");
		}
	}

}
