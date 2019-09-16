package service;

import java.util.List;
import model.Crm_customer;
import model.Crm_recode;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_recode_Service {
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯCrm_recode
	public Crm_recode selectByid(Integer id);
	
	// ��ѯCrm_sellman
	public List<Crm_sellman> selectsellman();
	
	// ��ѯCrm_customer
	public List<Crm_customer> selectcus();
	
	// ����
	public void insert(Crm_recode b);
	
	// �޸�
	public void update(Crm_recode b);
	
	// ɾ��
	public void delete(Crm_recode b);
}
