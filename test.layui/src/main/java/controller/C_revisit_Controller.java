package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_client;
import model.C_clienttype;
import model.C_revisit;
import service.C_revisit_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Revisit")
public class C_revisit_Controller {
	@Autowired
	C_revisit_Service service;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where c_revisit.clientid in(select id from c_client where name like '%"+txt+"%')";
		else txt="";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_revisit.name clientname,C_operator.name operatorname from (C_order inner join C_revisit on C_revisit.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_revisit b){
		service.insert(b);
		return new ReturnJson();
	}
	
	@RequestMapping("getClient")
	public @ResponseBody List<C_client> getClient(){
		return service.selectclient();
	}
	
	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return C_revisit.statuss;
	}
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return C_revisit.linkstatuss;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return C_revisit.clientstatuss;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return C_revisit.purposestatuss;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return C_revisit.assessstatuss;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return C_revisit.execstatuss;
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_revisit edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_revisit b){
		service.update(b);
		return new ReturnJson();
	}
	
	// 这里的id要与id : data.id 相对应
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
}
