package service;

import model.C_workgroup;
import utils.ReturnInfo;

public interface C_workgroup_Service {

	// ��ѯȫ��
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯһ��
	public C_workgroup selectById(Integer id);
	
	// ����
	public void insert(C_workgroup t);
	
	// �޸�
	public void update(C_workgroup t);
	
	// ɾ��
	public void delete(Integer id);
}
