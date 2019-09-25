package controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import model.C_clienttype;
import model.C_operator;
import model.C_revisit;
import model.C_src;
import model.Status;
import model.fenpei;
import model.plfenpei;
import service.C_client_Service;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Client")
public class C_client_Controller {
	@Autowired
	C_client_Service service;
	
	Date date = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo select(String txt,Integer page,Integer limit) {
		if(txt!=null&&txt.length()>0)txt=" where c_client.id in (select id from c_client where name like '%"+txt+"%')  and c_client.operatorids is null and c_client.count=0";
		else txt="  where  c_client.operatorids is null and c_client.count=0";
		//System.out.println("总查询代码：");
		//System.out.println("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id where C_order.id in (select c_order.id from c_order where id in (select id from c_client where name like '%"+txt+"%'))");
		return service.select(txt, page, limit);
	}

	// 新分配页显示
	@RequestMapping("newfp")
	public @ResponseBody ReturnInfo newfp(String txt,Integer page,Integer limit) {
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
		if(txt!=null&&txt.length()>0)txt=" where c_client.operatorids = '"+op.getId()+"' and c_client.name like '%"+txt+"%' and count = 0";
		else txt=" where c_client.operatorids = '"+op.getId()+"' and count = 0";
		//System.out.println(txt);
		return service.select(txt, page, limit);
	}

	// 回访预约页显示
	@RequestMapping("hfyy")
	public @ResponseBody ReturnInfo hfyy(String txt,Integer page,Integer limit) {
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
		if(txt!=null&&txt.length()>0)txt=" where c_client.operatorids = '"+op.getId()+"' and c_client.name like '%"+txt+"%' and assessstatus = 3 and count >0 and execstatus != 2";
		else txt=" where c_client.operatorids = '"+op.getId()+"' and assessstatus = 3 and count >0  and execstatus != 2";
		//System.out.println(txt);
		return service.select(txt, page, limit);
	}
	
	// 私人池页显示
	@RequestMapping("privatepool")
	public @ResponseBody ReturnInfo privatepool(String txt,Integer page,Integer limit) {
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
		if(txt!=null&&txt.length()>0)txt=" where c_client.operatorids = '"+op.getId()+"' and c_client.name like '%"+txt+"%' and assessstatus != 3 and count >0";
		else txt=" where c_client.operatorids = '"+op.getId()+"' and assessstatus != 3 and count >0";
		//System.out.println(txt);
		return service.select(txt, page, limit);
	}

	// 公共池显示
	@RequestMapping("publicpool") 
	public @ResponseBody ReturnInfo publicpool(String txt,Integer page,Integer limit) {
		
		if(txt!=null&&txt.length()>0)txt=" where c_client.id in (select id from c_client where name like '%"+txt+"%')  and c_client.operatorids is null and c_client.count>0";
		else txt=" where  c_client.operatorids is null and c_client.count>0";
		//System.out.println(txt);
		return service.select(txt, page, limit);
	}
	
	// 已完成 显示
	@RequestMapping("complete") 
	public @ResponseBody ReturnInfo complete(String txt,Integer page,Integer limit) {
		
		if(txt!=null&&txt.length()>0)txt=" where c_client.id in (select id from c_client where name like '%"+txt+"%') and execstatus = 2";
		else txt=" where execstatus = 2";
		//System.out.println(txt);
		return service.select(txt, page, limit);
	}
	
	
	// 新分配 回访
	@RequestMapping("updatehf")
	public @ResponseBody ReturnJson updatehf(C_revisit b){
		Status sta = new Status();
		// 设置客户id
		sta.setId(b.getId());
		int count = service.counthf(b.getId());
		int num = count + 1;
		//System.out.println(num);
		sta.setCount(num);
		sta.setAssessstatus(b.getAssessstatus());
		sta.setClientstatus(b.getClientstatus());
		sta.setExecstatus(b.getExecstatus());
		sta.setLinkstatus(b.getLinkstatus());
		sta.setPurposestatus(b.getPurposestatus());
		sta.setStatus(b.getStatus());
		service.updatec(sta);
		
		
		
		// 设置客户id
		b.setClientid(b.getId());
		String formatDate=sdf.format(date);
		// 自动插入当前日期
		b.setCreatedate(formatDate);
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
        // 自动插入当前登陆人员
		b.setOperatorid(op.getId());
		service.inserthf(b);
		return new ReturnJson();
	}
	
	@RequestMapping("insert")
	public @ResponseBody ReturnJson insert(C_client b){
		String formatDate=sdf.format(date);
		// 自动插入当前日期
		b.setCreatedate(formatDate);
		
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
        // 自动插入当前登陆人员
		b.setCreateoperatorid(op.getId());
		service.insert(b);
		return new ReturnJson();
	}

	@RequestMapping("getClient")
	public @ResponseBody List<C_client> getClient(){
		return service.selectclient();
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
		
		String formatDate=sdf.format(date);
		// 自动插入当前日期
		b.setCreatedate(formatDate);
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
        // 自动插入当前登陆人员
		b.setCreateoperatorid(op.getId());
		service.update(b);
		return new ReturnJson();
	}

	@RequestMapping("updateo")
	public @ResponseBody ReturnJson updateo(fenpei b){
		//System.out.println(b.getId());
		service.updateo(b);
		return new ReturnJson();
	}

	// 未分配 ->批量分配
	@RequestMapping("updateopl")
	public @ResponseBody ReturnJson updateopl(plfenpei b){
		//System.out.println(b.getIds());
		String str = b.getIds();
		List<String> array = stringToList(str);
		for (String ss : array) {
			Integer num = Integer.parseInt(ss);
			//System.out.println(num);
			b.setId(num);
			service.updateopl(b);
		}
		//service.updateopl(b);
		return new ReturnJson();
	}

	// 新分配 ->批量分配
	@RequestMapping("updateonpl")
	public @ResponseBody ReturnJson updateonpl(plfenpei b){
		String str = b.getIds();
		List<String> array = stringToList(str);
		for (String ss : array) {
			Integer num = Integer.parseInt(ss);
			//System.out.println(num);
			service.updateonpl(num);
		}
		//service.updateopl(b);
		return new ReturnJson();
	}
	
	// 公共池 ->批量分配给自己(把operator_ids设为=自己 ，回访次数设为=0)
	@RequestMapping("updatepubpl") 
	public @ResponseBody ReturnJson updatepubpl(plfenpei b){
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        C_operator op = (C_operator) session.getAttribute("C_operator");
		//System.out.println(op.getId());
		//System.out.println(b.getIds());
        
		String str = b.getIds();
		List<String> array = stringToList(str);
		for (String ss : array) {
			Integer num = Integer.parseInt(ss);
			//System.out.println(num);
			//service.updateonpl(num);
			b.setId(num);
			//System.out.println(b.getId());
			//System.out.println(b.getOperatorids());
	        //System.out.println(b.getOperatornames());
			service.updatepubpl(b); 
		}
		//service.updateopl(b);
		return new ReturnJson();
	}
	
	
	
	
	
	public static List<String> stringToList(String str) {
		return Arrays.asList(str.split(","));
	}
	
	// 这里的id要与id : data.id 相对应
	@RequestMapping("delete")
	public @ResponseBody ReturnJson delete(Integer id, ModelMap m) {
		service.delete(id);
		return new ReturnJson();
	}
}
