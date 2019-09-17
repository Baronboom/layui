package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_client;
import model.C_operator;
import model.C_order;
import service.C_order_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Order")
public class C_order_Controller {
	@Autowired
	C_order_Service service;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where C_order.id in (select c_order.id from c_order where c_order.clientid in (select id from c_client where name like '%"+txt+"%'))";
		else txt="";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_order b){
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getClient")
	public @ResponseBody List<C_client> getClient(){
		return service.selectclient();
	}
	
	@RequestMapping("getOperator")
	public @ResponseBody List<C_operator> getOperator(){
		return service.selectoperator();
	}

	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return C_order.statuss;
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_order edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_order b){
		service.update(b);
		return new ReturnJson();
	}
	
	// 这里的id要与id : data.id 相对应
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		System.out.println(id);
		service.delete(id);
		return new ReturnJson();
	}
}
