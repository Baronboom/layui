package service;

import model.C_product;
import utils.ReturnInfo;

public interface C_product_Service {
	// ��ѯȫ��
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯһ��
	public C_product selectById(Integer id);
	
	// ����
	public void insert(C_product t);
	
	// �޸�
	public void update(C_product t);
	
	// ɾ��
	public void delete(Integer id);
}
