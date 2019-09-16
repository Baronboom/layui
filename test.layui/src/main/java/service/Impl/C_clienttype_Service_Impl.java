package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_clienttype_Dao;
import model.C_clienttype;
import service.C_clienttype_Service;
import utils.ReturnInfo;

@Service
public class C_clienttype_Service_Impl implements C_clienttype_Service{
	@Autowired
	C_clienttype_Dao dao;
	
	// 查询全部
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// 查询一个
	public C_clienttype selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// 新增
	public void insert(C_clienttype t) {
		dao.insert(t);
	}

	// 修改
	public void update(C_clienttype t) {
		dao.update(t);
		
	}

	// 删除
	public void delete(Integer id) {
		dao.delete(id);
	}

}
