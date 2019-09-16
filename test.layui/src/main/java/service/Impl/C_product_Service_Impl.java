package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.C_product_Dao;
import model.C_product;
import service.C_product_Service;
import utils.ReturnInfo;
@Service
public class C_product_Service_Impl implements C_product_Service{
	@Autowired
	C_product_Dao dao;
	
	// ��ѯȫ��
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	// ��ѯһ��
	public C_product selectById(Integer id) {
		return dao.selectById(id);
	}
	
	// ����
	public void insert(C_product t) {
		dao.insert(t);
	}

	// �޸�
	public void update(C_product t) {
		dao.update(t);
		
	}

	// ɾ��
	public void delete(Integer id) {
		dao.delete(id);
	}

}
