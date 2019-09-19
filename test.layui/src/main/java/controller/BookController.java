package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import model.Type;
import service.Book_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Book")
public class BookController {

	@Autowired
	Book_Service service;
	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	
	// 查询   @ResponseBody 自动调用jakson，自动生成json语句返回。
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(Book b){
		service.insert(b);
		return new ReturnJson();
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody Book edit(Integer id){
		return service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(Book b){
		service.update(b);
		return new ReturnJson();
	}
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody List<Type> getTypes(){
		return service.selectType();
	}

	// 删除.
//	@RequestMapping("delete")
//	public @ResponseBody String delete(Book b, ModelMap m) {
//		service.delete(b);
//		return "{\"status\":1}";
//	}
	
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Book b, ModelMap m) {
		service.delete(b);
		return new ReturnJson();
	}
	
}
