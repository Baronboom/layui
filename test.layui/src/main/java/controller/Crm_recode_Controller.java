package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Crm_customer;
import model.Crm_recode;
import model.Crm_sellman;
import service.Crm_recode_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Recode")
public class Crm_recode_Controller {
	@Autowired
	Crm_recode_Service service;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where Crm_recode.csrname like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(Crm_recode b){
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getSellman")
	public @ResponseBody List<Crm_sellman> getSellman(){
		return service.selectsellman();
	}
	
	@RequestMapping("getCus")
	public @ResponseBody List<Crm_customer> getCus(){
		return service.selectcus();
	}

	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return Crm_recode.stas;
	}
	
	// ÐÞ¸Ä
	@RequestMapping("edit")
	public @ResponseBody Crm_recode edit(Integer id){
		System.out.println("ddddddddddddddddd");
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(Crm_recode b){
		service.update(b);
		return new ReturnJson();
	}
	
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Crm_recode b, ModelMap m) {
		service.delete(b);
		return new ReturnJson();
	}
}
