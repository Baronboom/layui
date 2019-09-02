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
import service.Type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController {

	@Autowired
	Type_Service service;

	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
		if (txt != null && txt.length() > 0)
			txt = " where type.name like '%" + txt + "%'";
		else
			txt = "";
		return service.select(txt, page, limit);
	}

	// 修改
	@RequestMapping("edit")
	public @ResponseBody Type edit(Integer id) {
		return service.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Type b) {
		service.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("insert")
	public @ResponseBody String insert(Type b) {
		service.insert(b);
		return "{\"status\":1}";
	}

	@RequestMapping("getTypes")
	public @ResponseBody Type getTypes(Integer id) {
		return service.selectById(id);
	}

	// 删除
	@RequestMapping("delete")
	public @ResponseBody String delete(Integer id, ModelMap m) {
		service.delete(id);
		return "{\"status\":1}";
	}

}
