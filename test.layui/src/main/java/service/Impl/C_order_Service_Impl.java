package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_order_Dao;
import model.C_client;
import model.C_operator;
import model.C_order;
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

}
