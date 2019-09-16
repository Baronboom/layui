package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Crm_department;
import model.Crm_sellman;
import model.Type;
import service.Crm_sellman_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Sellman")
public class Crm_sellman_Controller {

	@Autowired
	Crm_sellman_Service service;
	
	// 异常处理
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt, Integer page, Integer limit) {
		if (txt != null && txt.length() > 0)
			txt = " where Crm_sellman.name like '%" + txt + "%'";
		else
			txt = "";
		return service.select(txt, page, limit);
	}

	// 修改
	@RequestMapping("edit")
	public @ResponseBody Crm_sellman edit(Integer id) {
		return service.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(Crm_sellman b) {
		service.update(b);
		return new ReturnJson();
	}

	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(Crm_sellman b) {
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getCrm_sellmans")
	public @ResponseBody Crm_sellman getCrm_sellmans(Integer id) {
		return service.selectById(id);
	}

	// 删除
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
	
	@RequestMapping("getDeps")
	public @ResponseBody List<Crm_department> getDeps(){
		return service.selectDeps();
	}

}
