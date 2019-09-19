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
import model.C_reserved;
import model.C_revisit;
import service.C_reserved_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Reserved")
public class C_reserved_Controller {
	@Autowired
	C_reserved_Service service;
	
	Date date = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where c_client.id in (select id from c_client where name like '%"+txt+"%')";
		else txt="";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_reserved b){
		String formatDate=sdf.format(date);
		b.setCreatedate(formatDate);
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
        b.setOperatorid(op.getId());
		service.insert(b);
		return new ReturnJson();
	}
	
	
	@RequestMapping("getRevisit")
	public @ResponseBody List<C_revisit> getRevisit(){
		return service.selectrevisit();
	}
/*	@RequestMapping("getOperator")
	public @ResponseBody List<C_operator> getOperator(){
		return service.selectoperator();
	}*/
	@RequestMapping("getClient")
	public @ResponseBody List<C_client> getClient(){
		return service.selectclient();
	}
	
	@RequestMapping("getExecoperator")
	public @ResponseBody List<C_operator> getExecoperator(){
		return service.selectexecoperator();
	}
	
	
	@RequestMapping("getStas")
	public @ResponseBody String[] getStas() {
		return C_reserved.statuss;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody String[] getTypes() {
		return C_reserved.types;
	}
	
	@RequestMapping("getExecstatsus")
	public @ResponseBody String[] getExecstatsus() {
		return C_reserved.execstatsus;
	}
	
	
	// 修改
	@RequestMapping("edit")
	public @ResponseBody C_reserved edit(Integer id){
		return 	service.selectByid(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody ReturnJson update(C_reserved b){
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
