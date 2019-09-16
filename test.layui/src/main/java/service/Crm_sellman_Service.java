package service;

import java.util.List;

import model.Crm_department;
import model.Crm_sellman;
import utils.ReturnInfo;

public interface Crm_sellman_Service {
	// ��ѯȫ��
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯһ��
	public Crm_sellman selectById(Integer id);
	
	// ��ѯCrm_department
	public List<Crm_department> selectDeps();
	
	// ����
	public void insert(Crm_sellman t);
	
	// �޸�
	public void update(Crm_sellman t);
	
	// ɾ��
	public void delete(Integer id);
}
