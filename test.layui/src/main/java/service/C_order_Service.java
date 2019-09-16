package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_order;
import utils.ReturnInfo;

public interface C_order_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯCrm_recode
	public C_order selectByid(Integer id);
	
	// ��ѯoperator
	public List<C_operator> selectoperator();
	
	// ��ѯC_client
	public List<C_client> selectclient();
	
	// ����
	public void insert(C_order b);
	
	// �޸�
	public void update(C_order b);
	
	// ɾ��
	public void delete(Integer b);
}
