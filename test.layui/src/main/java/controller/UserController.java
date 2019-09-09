package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import service.User_Service;

@Controller
public class UserController {
	@Autowired
	User_Service service;

	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@ResponseBody
	@RequestMapping("login")
	public String login(User u, ModelMap m, HttpSession s) {
		System.out.println(u.getName());
		System.out.println(u.getPass());
		System.out.println("dddddddddddddddd");
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(), u.getPass()));
		} catch (AccountException e) {
			System.out.println("出错了");
			return "redirect:/login.html";
		}
		return "{\"info\":\"index.html\"}";
	}

	@RequestMapping("outlogin")
	public String login(HttpSession s,HttpServletRequest req) {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}

	@RequestMapping("index")
	public String index(String txt, ModelMap m) {
		String where = "";
		if (txt != null) {
			where = " where grades.name like '%" + txt + "%'";
		}
		m.put("list", service.select(where));
		return "User/index";
	}

	// 新增
	@RequestMapping("add")
	public String add(ModelMap m) {
		return "User/edit";
	}

	// 新增
	@RequestMapping("insert")
	public String insert(User b, ModelMap m) {
		service.insert(b);
		return index(null, m);
	}

	// 修改
	@RequestMapping("edit")
	public String edit(int id, ModelMap m) {
		m.put("info", service.selectById(id));
		return "User/edit";
	}

	// 修改
	@RequestMapping("update")
	public String update(User b, ModelMap m) {
		service.update(b);
		return index(null, m);
	}

	// 删除
	@RequestMapping("delete")
	public String delete(int id, ModelMap m) {
		service.delete(id);
		return index(null, m);
	}
}
