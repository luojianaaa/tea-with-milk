package com.java.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.java.bean.AdministratorsBean;
import com.java.bean.UserBean;
import com.java.bean.commodityBean;

public class DBUtil {
	//添加或修改菜单
	public void insert2(commodityBean cBean) throws SQLException {
		boolean flag = false;
		DBUtil db = new DBUtil();
		List<commodityBean> findAll1 = db.findAll1();
		for (commodityBean SBean : findAll1) {
			if (cBean.getCoid().equals(SBean.getCoid())) {
				flag = true;
				break;
			}else {
				flag = false;
			}
		}
		
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		if (flag) {
			String sql= "UPDATE commodity SET coname=?,coprice=?,costock=? where coid=?";
			runner.update(sql, new Object[] 
					{ cBean.getConame(), cBean.getCoprice(), cBean.getCostock(), cBean.getCoid() });
			System.out.println("修改成功");
		}else {
			String sql= "insert into commodity (coid,coname,coprice,costock) values (?,?,?,?)";
			runner.update(sql, new Object[] 
					{ cBean.getCoid(), cBean.getConame(), cBean.getCoprice(), cBean.getCostock() });
			System.out.println("添加成功");
		}
	}
	
	//查询管理员账号密码
	public List<AdministratorsBean> findAll2() throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from administrators";
		List<AdministratorsBean> list = 
				(List<AdministratorsBean>) runner.query(sql, new BeanListHandler<AdministratorsBean>(AdministratorsBean.class));
		return list;
	}
	//判断管理员账号密码
	public boolean insert1(AdministratorsBean Bean) throws SQLException {
		boolean flag = false;
		DBUtil db = new DBUtil();
		List<AdministratorsBean> findAll = db.findAll2();
		for (AdministratorsBean SBean : findAll) {
			if (SBean.getAnum().equals(Bean.getAnum()) && SBean.getApassword().equals(Bean.getApassword())) {
				flag = true;
				break;
			}else {
				flag = false;
			}
		}
		
		return flag;
	}
	//查询菜单
	public List<commodityBean> findAll1() throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from commodity";
		List<commodityBean> list = 
				(List<commodityBean>) runner.query(sql, new BeanListHandler<commodityBean>(commodityBean.class));
		return list;
	}
	//查询手机号码
	public List<UserBean> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from customer";
		List<UserBean> list = 
				(List<UserBean>) runner.query(sql, new BeanListHandler<UserBean>(UserBean.class));
		return list;
	}
	//登录注册顾客
	public void insert(String phonenumber,UserBean userBean) throws SQLException {
		boolean flag = false;
		DBUtil db = new DBUtil();
		List<UserBean> findAll = db.findAll();
		for (UserBean userBean1 : findAll) {
			if (userBean1.getCphonenumber().equals(phonenumber)) {
				flag = false;
				break;
			}else {
				flag = true;
			}
		}
		if (flag) {
			QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
			String sql= "insert into customer (cid,cphonenumber) values (?,?)";
			runner.update(sql, new Object[] { userBean.getCid(), userBean.getCphonenumber() });
			System.out.println("自动注册");
		}else {
			System.out.println("已注册");
		}
	}
}