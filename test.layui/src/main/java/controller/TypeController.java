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
import utils.ReturnJson;
import utils.SearchInfo;

@Controller
@RequestMapping("Type")
public class TypeController  extends BasicController<Type> {

	@Autowired
	Type_Service service;

	@Override
	public @ResponseBody ReturnInfo index(SearchInfo info, Integer page, Integer limit, ModelMap m) {
		String where = "";
		if (info.getTxt()!= null && info.getTxt().length() > 0)
			where = " where type.name like '%" + info.getTxt() + "%'";
		else
			where = "";
		return service.select(where, page, limit);
	}
	
//	// 异常处理
//	@ExceptionHandler
//	public void ex(Exception e) {
//		e.printStackTrace();
//	}
//
//	@RequestMapping("index")
//	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
//		if (txt != null && txt.length() > 0)
//			txt = " where type.name like '%" + txt + "%'";
//		else
//			txt = "";
//		return service.select(txt, page, limit);
//	}
//
//	// 修改
//	@RequestMapping("edit")
//	public @ResponseBody Type edit(Integer id) {
//		return service.selectById(id);
//	}
//	@RequestMapping("update")
//	public @ResponseBody ReturnJson update(Type b) {
//		service.update(b);
//		return new ReturnJson();
//	}
//
//	@RequestMapping("insert")
//	public @ResponseBody ReturnJson insert(Type b) {
//		service.insert(b);
//		return new ReturnJson();
//	}
//
//	@RequestMapping("getTypes")
//	public @ResponseBody Type getTypes(Integer id) {
//		return service.selectById(id);
//	}
//
//	// 删除
//	@RequestMapping("delete")
//	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
//		service.delete(id);
//		return new ReturnJson();
//	}

}
