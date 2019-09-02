package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	// page ����ҳ����limit���� limit��/ҳ
	@GetMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	// ����
	@PostMapping("insert")
	public @ResponseBody String insert(Book b){
		service.insert(b);
		return "{\"status\":1}";
	}
	
	// �޸�
	@GetMapping("{id}")
	public @ResponseBody Book edit(@PathVariable("id") Integer id){
		return service.selectByid(id);
	}
	
	@PutMapping("{id}")
	public @ResponseBody String update(Book b){
		service.update(b);
		return "{\"status\":1}";
	}
	
	@GetMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@GetMapping("getTypes")
	public @ResponseBody List<Type> getTypes(){
		return service.selectType();
	}

	@DeleteMapping("{id}")
	public @ResponseBody String delete(Book b, ModelMap m) {
		service.delete(b);
		return "{\"status\":1}";
	}
	
}
