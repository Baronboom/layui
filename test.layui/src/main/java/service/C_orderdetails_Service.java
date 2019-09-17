package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import utils.ReturnInfo;

public interface C_orderdetails_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_order
	public C_orderdetails selectByid(Integer id);
	
	// ��ѯC_product
	public List<C_product> selectproduct();
	
	// ��ѯC_order
	public List<C_order> selectorder();
	
	// ����
	public void insert(C_orderdetails b);
	
	// �޸�
	public void update(C_orderdetails b);
	
	// ɾ��
	public void delete(Integer id);
}
