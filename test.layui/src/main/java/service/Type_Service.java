package service;

import java.util.List;


import model.Type;
import utils.ReturnInfo;

public interface Type_Service {
	
	// ��ѯȫ��
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯһ��
	public Type selectById(Integer id);
	
	// ����
	public void insert(Type t);
	
	// �޸�
	public void update(Type t);
	
	// ɾ��
	public void delete(Integer id);
}
