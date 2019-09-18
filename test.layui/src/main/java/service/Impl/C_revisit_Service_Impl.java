package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_revisit_Dao;
import model.C_client;
import model.C_revisit;
import service.C_revisit_Service;
import utils.ReturnInfo;

@Service
public class C_revisit_Service_Impl implements C_revisit_Service{
	@Autowired
	C_revisit_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public C_revisit selectByid(Integer id) {
		return (C_revisit)dao.select(" where C_revisit.id="+id," limit 1").get(0);
	}
	
	public void insert(C_revisit b) {
		dao.insert(b);
	}

	public void update(C_revisit b) {
		dao.update(b);
	}

	public void delete(Integer b) {
		dao.delete(b);
	}

	public List<C_client> selectclient() {
		return dao.selectclient();
	}
}
