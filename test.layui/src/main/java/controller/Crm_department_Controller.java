package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Crm_department;
import service.Crm_department_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Department")
public class Crm_department_Controller {

	@Autowired
	Crm_department_Service service;
	
	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
		if (txt != null && txt.length() > 0)
			txt = " where Crm_department.name like '%" + txt + "%'";
		else
			txt = "";
		return service.select(txt, page, limit);
	}

	// 修改
	@RequestMapping("edit")
	public @ResponseBody Crm_department edit(Integer id) {
		return service.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(Crm_department b) {
		service.update(b);
		return new ReturnJson();
	}

	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(Crm_department b) {
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getCrm_departments")
	public @ResponseBody Crm_department getCrm_departments(Integer id) {
		return service.selectById(id);
	}

	// 删除
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
}
