package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Crm_department_Dao;
import model.Crm_department;
import service.Crm_department_Service;
import utils.ReturnInfo;
@Service
public class Crm_department_Service_Impl implements Crm_department_Service{
	
	@Autowired
	Crm_department_Dao dao;
	
	// ��ѯȫ��
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// ��ѯһ��
	public Crm_department selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// ����
	public void insert(Crm_department t) {
		dao.insert(t);
	}

	// �޸�
	public void update(Crm_department t) {
		dao.update(t);
		
	}

	// ɾ��
	public void delete(Integer id) {
		dao.delete(id);
	}
}
