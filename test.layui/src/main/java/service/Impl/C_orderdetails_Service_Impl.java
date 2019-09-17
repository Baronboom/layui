package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_orderdetails_Dao;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import service.C_orderdetails_Service;
import utils.ReturnInfo;

@Service
public class C_orderdetails_Service_Impl implements C_orderdetails_Service{
	@Autowired
	C_orderdetails_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public C_orderdetails selectByid(Integer id) {
		return (C_orderdetails)dao.select(" where C_orderdetails.id="+id," limit 1").get(0);
	}

	public List<C_product> selectproduct() {
		return dao.selectproduct();
	}

	public List<C_order> selectorder() {
		return dao.selectorder();
	}

	public void insert(C_orderdetails b) {
		dao.insert(b);
	}

	public void update(C_orderdetails b) {
		dao.update(b);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}
}
