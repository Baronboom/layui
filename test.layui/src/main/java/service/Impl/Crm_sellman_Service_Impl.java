package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Crm_sellman_Dao;
import model.Crm_department;
import model.Crm_sellman;
import service.Crm_sellman_Service;
import utils.ReturnInfo;

@Service
public class Crm_sellman_Service_Impl implements Crm_sellman_Service {

	@Autowired
	Crm_sellman_Dao dao;
	
	// ��ѯȫ��
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// ��ѯһ��
	public Crm_sellman selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// ����
	public void insert(Crm_sellman t) {
		dao.insert(t);
	}

	// �޸�
	public void update(Crm_sellman t) {
		dao.update(t);
		
	}

	// ɾ��
	public void delete(Integer id) {
		dao.delete(id);
	}

	public List<Crm_department> selectDeps() {
		return dao.selectDeps();
	}

}
