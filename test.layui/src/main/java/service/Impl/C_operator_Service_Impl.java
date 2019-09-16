package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_operator_Dao;
import model.C_operator;
import model.C_workgroup;
import service.C_operator_Service;
import utils.ReturnInfo;
@Service
public class C_operator_Service_Impl implements C_operator_Service{
	@Autowired
	C_operator_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	public C_operator selectByid(Integer id) {
		return  (C_operator) dao.select(" where C_operator.id="+id," limit 1").get(0);
	}

	public void insert(C_operator b) {
		dao.insert(b);
	}

	public void update(C_operator b) {
		dao.update(b);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<C_workgroup> selectWorkgroup() {
		return dao.selectWorkgroup();
	}

}
