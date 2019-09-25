package controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import service.C_order_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Order")
public class C_order_Controller {
	@Autowired
	C_order_Service service;
	
	Date date = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//最后一步，利用格式化对象格式化日期对象，返回格式化的时间字符串
	
	
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
		String formatDate=sdf.format(date);
		// 自动插入当前日期
		b.setCreatedate(formatDate);
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
        // 自动插入当前登陆人员
		b.setOperatorid(op.getId());
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
	// ---------------------------待删
	@RequestMapping("edit")
	public @ResponseBody C_order edit(Integer id){
		return 	service.selectByid(id);
	}
	
	//----------------------------新增
	@RequestMapping("getOrder")
	public @ResponseBody List<C_order> getOrder(){
		return service.selectorder();
	}
	
	@RequestMapping("getProduct")
	public @ResponseBody List<C_product> getProduct(){
		return service.selectproduct();
	}

	@RequestMapping("edito")
	public @ResponseBody C_orderdetails edito(Integer id){
		return 	service.selecotByid(id);
	}
	
	// 已完成客户 合同明细查看
	@RequestMapping("editend")
	public @ResponseBody C_orderdetails editend(Integer id){
		return 	service.selecend(id);
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
