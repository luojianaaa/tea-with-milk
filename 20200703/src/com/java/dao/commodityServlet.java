package com.java.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.commodityBean;
import com.java.util.DBUtil;

public class commodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//添加或修改菜单
		String coid = request.getParameter("coid");
		String coname = request.getParameter("coname");
		String coprice = request.getParameter("coprice");
		String costock = request.getParameter("costock");
		commodityBean cBean = new commodityBean();
		cBean.setCoid(coid);
		cBean.setConame(coname);
		cBean.setCoprice(coprice);
		cBean.setCostock(costock);
		try {
		if (coid != null && coname != null && coprice != null && costock != null) {
				DBUtil db = new DBUtil();
				db.insert2(cBean);
				List<commodityBean> findAll1 = db.findAll1();
				request.getSession().setAttribute("commodityBean", findAll1);
				request.getRequestDispatcher("Administrators.jsp").forward(request, response);
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

}
