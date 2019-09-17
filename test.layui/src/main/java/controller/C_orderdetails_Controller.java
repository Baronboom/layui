package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_order;
import model.C_orderdetails;
import model.C_product;
import service.C_orderdetails_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Orderdetails")
public class C_orderdetails_Controller {
	@Autowired
	C_orderdetails_Service service;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where C_orderdetails.id in (select C_orderdetails.id from C_orderdetails where C_orderdetails.orderid in (select id from C_order where name like '%"+txt+"%'))";
		else txt="";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_orderdetails b){
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getProduct")
	public @ResponseBody List<C_product> getProduct(){
		return service.selectproduct();
	}
	
	@RequestMapping("getOrder")
	public @ResponseBody List<C_order> getOrder(){
		return service.selectorder();
	}
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_orderdetails edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_orderdetails b){
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
