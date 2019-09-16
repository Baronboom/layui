package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_workgroup_Dao;
import model.C_workgroup;
import service.C_workgroup_Service;
import utils.ReturnInfo;
@Service
public class C_workgroup_Service_Impl implements C_workgroup_Service{
	@Autowired
	C_workgroup_Dao dao;
	

	// 查询全部
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// 查询一个
	public C_workgroup selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// 新增
	public void insert(C_workgroup t) {
		dao.insert(t);
	}

	// 修改
	public void update(C_workgroup t) {
		dao.update(t);
		
	}

	// 删除
	public void delete(Integer id) {
		dao.delete(id);
	}


}
