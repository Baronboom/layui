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

	@GetMapping("index")
	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
		if (txt != null && txt.length() > 0)
			txt = " where type.name like '%" + txt + "%'";
		else
			txt = "";
		return service.select(txt, page, limit);
	}

	// 修改
	@GetMapping("{id}")
	public @ResponseBody Type edit(@PathVariable("id") Integer id) {
		return service.selectById(id);
	}
	// 修改
	@PutMapping("{id}")
	public @ResponseBody String update(Type b) {
		service.update(b);
		return "{\"status\":1}";
	}

	// 新增
	// @PostMapping("insert") 等价于 @PostMapping(value="insert")
	@PostMapping("insert")
	public @ResponseBody String insert(Type b) {
		service.insert(b);
		return "{\"status\":1}";
	}

	// 删除
	@DeleteMapping("{id}")
	public @ResponseBody String delete(@PathVariable("id") Integer id, ModelMap m) {
		service.delete(id);
		return "{\"status\":1}";
	}

}
