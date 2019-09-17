package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_src;
import service.C_client_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Client")
public class C_client_Controller {
	@Autowired
	C_client_Service service;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where c_client.id in (select id from c_client where name like '%"+txt+"%')";
		else txt="";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_client b){
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getClienttype")
	public @ResponseBody List<C_clienttype> getClienttype(){
		return service.selectclienttype();
	}
	@RequestMapping("getOperator")
	public @ResponseBody List<C_operator> getOperator(){
		return service.selectoperator();
	}
	@RequestMapping("getSrc")
	public @ResponseBody List<C_src> getSrc(){
		return service.selectsrc();
	}
	
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return C_client.sexss;
	}
	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return C_client.statuss;
	}
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return C_client.linkstatuss;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return C_client.clientstatuss;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return C_client.purposestatuss;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return C_client.assessstatuss;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return C_client.execstatuss;
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_client edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_client b){
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
