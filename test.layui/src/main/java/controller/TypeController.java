package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Type;
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController  extends BasicController<Type> {

	@Autowired
	Type_Service service;

	@Override
	@GetMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit,ModelMap m) {
		System.out.println("basic_index");
		if(txt!=null&&txt.length()>0)txt=" where type.name like '%"+txt+"%'";
		else txt="";
		return basicservice.select(txt,page,limit);
	}
	@GetMapping("getTypes")
	public @ResponseBody List<Type> getTypes(){
		return service.selectType();
	}
	
//	@RequestMapping("index")
//	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
//		if (txt != null && txt.length() > 0)
//			txt = " where type.name like '%" + txt + "%'";
//		else
//			txt = "";
//		return service.select(txt, page, limit);
//	}

}
