package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_client_Dao;
import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_src;
import service.C_client_Service;
import utils.ReturnInfo;

@Service
public class C_client_Service_Impl implements C_client_Service{
	@Autowired
	C_client_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public C_client selectByid(Integer id) {
		return (C_client)dao.select(" where C_client.id="+id," limit 1").get(0);
	}

	public List<C_operator> selectoperator() {
		return dao.selectoperator();
	}

	public List<C_clienttype> selectclienttype() {
		return dao.selectclienttype();
	}

	public List<C_src> selectsrc() {
		return dao.selectsrc();
	}
	
	public void insert(C_client b) {
		dao.insert(b);
	}

	public void update(C_client b) {
		dao.update(b);
	}

	public void delete(Integer b) {
		dao.delete(b);
	}
	
}