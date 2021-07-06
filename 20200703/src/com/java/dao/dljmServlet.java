package com.java.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.RegisterFormBean;
import com.java.bean.UserBean;
import com.java.bean.commodityBean;
import com.java.util.DBUtil;

public class dljmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取表单信息
		String phonenumber = request.getParameter("phonenumber");
		String Lcheck_code = request.getParameter("check_code");
		String Scheck_code = (String) request.getSession().getAttribute("check_code");
		//判断信息格式
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setPhonenumber(phonenumber);
		formBean.setLcheck_code(Lcheck_code);
		formBean.setScheck_code(Scheck_code);
		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/dljm.jsp").forward(request, response);
			return;
		}
		//判断数据库
		try {
			UserBean userBean = new UserBean();
			userBean.setCphonenumber(phonenumber);			
			request.getSession().setAttribute("userBean", userBean);
			DBUtil db = new DBUtil();
			db.insert(phonenumber, userBean);
			response.getWriter().print("恭喜您登录成功！1秒自动跳转.......");
			response.setHeader("refresh", "1;url=login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DBUtil db = new DBUtil();
			List<commodityBean> findAll1 = db.findAll1();
			request.getSession().setAttribute("commodityBean", findAll1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
