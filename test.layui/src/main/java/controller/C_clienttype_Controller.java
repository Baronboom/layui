package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_clienttype;
import service.C_clienttype_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Clienttype")
public class C_clienttype_Controller {
	@Autowired
	C_clienttype_Service service;
	
	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
		if (txt != null && txt.length() > 0)
			txt = " where C_clienttype.name like '%" + txt + "%'";
		else
			txt = "";
		return service.select(txt, page, limit);
	}

	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_clienttype edit(Integer id) {
		return service.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_clienttype b) {
		service.update(b);
		return new ReturnJson();
	}

	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_clienttype b) {
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getClienttypes")
	public @ResponseBody C_clienttype getClienttypes(Integer id) {
		return service.selectById(id);
	}

	// 删除
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
}
