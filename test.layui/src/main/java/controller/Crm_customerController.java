package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import model.Crm_customer;
import model.Crm_sellman;
import model.Type;
import service.Crm_customer_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("customer")
public class Crm_customerController {
	
	@Autowired
	Crm_customer_Service service;
	
	// 查询   @ResponseBody 自动调用jakson，自动生成json语句返回
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where Crm_customer.csrname like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(Crm_customer b){
		service.insert(b);
		return new ReturnJson();
	}
	
	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return Crm_customer.stas;
	}
	
	@RequestMapping("getSellman")
	public @ResponseBody List<Crm_sellman> getSellman(){
		return service.selectsellman();
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody Crm_customer edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(Crm_customer b){
		service.update(b);
		return new ReturnJson();
	}
	
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Crm_customer b, ModelMap m) {
		service.delete(b);
		return new ReturnJson();
	}
}
