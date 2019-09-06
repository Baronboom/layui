package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import model.Type;
import service.Book_Service;
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Book")
public class BookController extends BasicController<Book> {

	@Autowired
	Book_Service service;
	@Autowired
	Type_Service tservice;
//	
//	// 查询   @ResponseBody 自动调用jakson，自动生成json语句返回
//	@RequestMapping("index")
//	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
//		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
//		else txt="";
//		return service.select(txt, page, limit);
//	}
	
	@GetMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit,ModelMap m) {
		System.out.println("basic_index");
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return basicservice.select(txt,page,limit);
	}

	@GetMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@GetMapping("getTypes")
	public @ResponseBody List<Type> getTypes(){
		return tservice.selectType();
	}

}
