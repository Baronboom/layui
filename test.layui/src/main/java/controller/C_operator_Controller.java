package controller;

import java.util.List;

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

import model.C_operator;
import model.C_workgroup;
import model.User;
import service.C_operator_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Operator")
public class C_operator_Controller {
	@Autowired
	C_operator_Service service;
	
	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	
	@RequestMapping("login")
	public String login(C_operator u, ModelMap m, HttpSession s) {
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(), u.getPass()));
		} catch (AccountException e) {
			// return "{\"info\":\"login.html\"}";
			return "redirect:/login.html";
		}
		// return "{\"info\":\"index.html\"}";
		return "redirect:/index.html";
	}
	
	// 查询   @ResponseBody 自动调用jakson，自动生成json语句返回
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where C_operator.name like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_operator b){
		service.insert(b);
		return new ReturnJson();
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_operator edit(Integer id){
		return service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_operator b){
		service.update(b);
		return new ReturnJson();
	}

	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return C_operator.statuss;
	}
	
	@RequestMapping("getPower")
	public @ResponseBody String[] getPower() {
		return C_operator.powers;
	}
	
	@RequestMapping("getWorkgroup")
	public @ResponseBody List<C_workgroup> getWorkgroup(){
		return service.selectWorkgroup();
	}

	// 删除
//	@RequestMapping("delete")
//	public @ResponseBody String delete(C_operator b, ModelMap m) {
//		service.delete(b);
//		return "{\"status\":1}";
//	}
	
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
}
