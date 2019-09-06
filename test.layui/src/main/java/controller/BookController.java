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
import service.Type_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Book")
public class BookController extends BasicController<Book> {

	@Autowired
	Book_Service service;
	@Autowired
	Type_Service tservice;
	// �쳣����
//	@ExceptionHandler
//	public void ex(Exception e) {
//		e.printStackTrace();
//	}
//	
//	// ��ѯ   @ResponseBody �Զ�����jakson���Զ�����json��䷵��
//	@RequestMapping("index")
//	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
//		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
//		else txt="";
//		return service.select(txt, page, limit);
//	}
//	
//	@RequestMapping("insert")
//	public @ResponseBody ReturnJson insert(Book b){
//		service.insert(b);
//		return new ReturnJson();
//	}
//	
//	// �޸�
//	@RequestMapping("edit")
//	public @ResponseBody Book edit(Integer id){
//		return service.selectById(id);
//	}
//	
//	@RequestMapping("update")
//	public @ResponseBody ReturnJson update(Book b){
//		service.update(b);
//		return new ReturnJson();
//	}
//	
//	@RequestMapping("getSexs")
//	public @ResponseBody String[] getSexs() {
//		return Book.sexs;
//	}
//	
//	@RequestMapping("getTypes")
//	public @ResponseBody List<Type> getTypes(){
//		return service.selectType();
//	}

	// ɾ��
//	@RequestMapping("delete")
//	public @ResponseBody String delete(Book b, ModelMap m) {
//		service.delete(b);
//		return "{\"status\":1}";
//	}
	
//	@RequestMapping("delete")
//	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
//		service.delete(id);
//		return new ReturnJson();
//	}
	
}
