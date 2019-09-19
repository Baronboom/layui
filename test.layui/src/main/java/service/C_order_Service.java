package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import utils.ReturnInfo;

public interface C_order_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_order
	public C_order selectByid(Integer id);
	
	public C_orderdetails selecotByid(Integer id);
	
	// ��ѯoperator
	public List<C_operator> selectoperator();
	
	// ��ѯC_client
	public List<C_client> selectclient();
	
	// ��ѯC_product
	public List<C_product> selectproduct();
	
	// ����
	public void insert(C_order b);
	
	// �޸�
	public void update(C_order b);
	
	// ɾ��
	public void delete(Integer b);
	
	public List<C_order> selectorder();
}
