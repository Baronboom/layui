package service;

import model.Crm_department;
import utils.ReturnInfo;

public interface Crm_department_Service {
	// ��ѯȫ��
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯһ��
	public Crm_department selectById(Integer id);
	
	// ����
	public void insert(Crm_department t);
	
	// �޸�
	public void update(Crm_department t);
	
	// ɾ��
	public void delete(Integer id);
}
