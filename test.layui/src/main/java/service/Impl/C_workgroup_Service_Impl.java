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
	

	// ��ѯȫ��
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// ��ѯһ��
	public C_workgroup selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// ����
	public void insert(C_workgroup t) {
		dao.insert(t);
	}

	// �޸�
	public void update(C_workgroup t) {
		dao.update(t);
		
	}

	// ɾ��
	public void delete(Integer id) {
		dao.delete(id);
	}


}
