package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_order_Dao;
import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import service.C_order_Service;
import utils.ReturnInfo;


@Service
public class C_order_Service_Impl implements C_order_Service{
	@Autowired
	C_order_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public C_order selectByid(Integer id) {
		return (C_order)dao.select(" where C_order.id="+id," limit 1").get(0);
	}

	public C_orderdetails selecotByid(Integer id) {
		return (C_orderdetails)dao.selecto(" where c_orderdetails.orderid="+id," limit 1").get(0);
	}

	public C_orderdetails selecend(Integer id) {
		return (C_orderdetails)dao.selectend(" where c_orderdetails.orderid in (select c_order.id from c_order where c_order.clientid = '"+id+"')"," limit 1").get(0);
	}
	
	public List<C_operator> selectoperator() {
		return dao.selectoperator();
	}

	public List<C_client> selectclient() {
		return dao.selectclient();
	}

	public void insert(C_order b) {
		dao.insert(b);
	}

	public void update(C_order b) {
		dao.update(b);
	}

	public void delete(Integer b) {
		dao.delete(b);
	}
	public List<C_order> selectorder() {
		return dao.selectorder();
	}
	
	public List<C_product> selectproduct() {
		return dao.selectproduct();
	}

}
