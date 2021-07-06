package com.java.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.AdministratorsBean;
import com.java.bean.commodityBean;
import com.java.bean.glydlFormBean;
import com.java.util.DBUtil;

public class glydlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取表单信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//判断信息格式
		glydlFormBean formBean = new glydlFormBean();
		formBean.setUsername(username);
		formBean.setPassword(password);
		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/glydl.jsp").forward(request, response);
			return;
		}
		
		//判断数据库
		try {
			AdministratorsBean bean = new AdministratorsBean();
			bean.setAnum(username);
			bean.setApassword(password);
			DBUtil db = new DBUtil();
			boolean b = db.insert1(bean);
			if (!b) {
				request.setAttribute("AdministratorsBean", "用户名或密码错误");
				request.getRequestDispatcher("/glydl.jsp").forward(request, response);
				return;
			}
			List<commodityBean> findAll1 = db.findAll1();
			request.getSession().setAttribute("commodityBean", findAll1);
			request.getRequestDispatcher("Administrators.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}