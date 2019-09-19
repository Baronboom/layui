package service;

import java.util.List;

import model.C_operator;
import model.C_workgroup;
import model.User;
import utils.ReturnInfo;

public interface C_operator_Service {
	
	public C_operator login(C_operator u);
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_operator
	public C_operator selectByid(Integer id);
	
	// ��ѯC_workgroup
	public List<C_workgroup> selectWorkgroup();
	
	// ����
	public void insert(C_operator b);
	
	// �޸�
	public void update(C_operator b);
	
	// ɾ��
	public void delete(Integer b);

}
