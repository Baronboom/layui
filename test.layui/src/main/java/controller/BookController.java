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

@Controller
@RequestMapping("Book")
public class BookController {

	@Autowired
	Book_Service service;
	// �쳣����
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	
	// ��ѯ   @ResponseBody �Զ�����jakson���Զ�����json��䷵��
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Book b){
		service.insert(b);
		return "{\"status\":1}";
	}
	
	// �޸�
	@RequestMapping("edit")
	public @ResponseBody Book edit(Integer id){
		return service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(Book b){
		service.update(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody List<Type> getTypes(){
		return service.selectType();
	}

	// ɾ��
	@RequestMapping("delete")
	public @ResponseBody String delete(Book b, ModelMap m) {
		service.delete(b);
		return "{\"status\":1}";
	}
	
}
