package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_client;
import model.C_operator;
import model.C_order;
import service.C_order_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Order")
public class C_order_Controller {
	@Autowired
	C_order_Service service;
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where C_order.csrname like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_order b){
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getClient")
	public @ResponseBody List<C_client> getClient(){
		return service.selectclient();
	}
	
	@RequestMapping("getOperator")
	public @ResponseBody List<C_operator> getOperator(){
		return service.selectoperator();
	}

	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return C_order.statuss;
	}
	
	// ÐÞ¸Ä
	@RequestMapping("edit")
	public @ResponseBody C_order edit(Integer id){
		System.out.println("ddddddddddddddddd");
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_order b){
		service.update(b);
		return new ReturnJson();
	}
	
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer b, ModelMap m) {
		service.delete(b);
		return new ReturnJson();
	}
}
