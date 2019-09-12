package service;

import java.util.List;

import model.Crm_customer;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_customer_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯCrm_customer
	public Crm_customer selectByid(Integer id);
	
	// ��ѯCrm_sellman
	public List<Crm_sellman> selectsellman();
	
	// ����
	public void insert(Crm_customer b);
	
	// �޸�
	public void update(Crm_customer b);
	
	// ɾ��
	public void delete(Crm_customer b);
}
