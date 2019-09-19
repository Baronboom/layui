package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_reserved_Dao;
import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_reserved;
import model.C_revisit;
import service.C_reserved_Service;
import service.C_revisit_Service;
import utils.ReturnInfo;

@Service
public class C_reserved_Service_Impl implements C_reserved_Service{
	@Autowired
	C_reserved_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public C_reserved selectByid(Integer id) {
		return (C_reserved)dao.select(" where C_reserved.id="+id," limit 1").get(0);
	}
	
	public List<C_revisit> selectrevisit() {
		return dao.selectrevisit();
	}

	public List<C_client> selectclient() {
		return dao.selectclient();
	}

	public List<C_operator> selectoperator() {
		return dao.selectoperator();
	}

	public List<C_operator> selectexecoperator() {
		return dao.selectexecoperator();
	}
	
	public void insert(C_reserved b) {
		dao.insert(b);
	}

	public void update(C_reserved b) {
		dao.update(b);
	}

	public void delete(Integer b) {
		dao.delete(b);
	}

}
