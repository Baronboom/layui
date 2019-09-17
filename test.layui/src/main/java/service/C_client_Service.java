package service;

import java.util.List;
import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_src;
import utils.ReturnInfo;

public interface C_client_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_client
	public C_client selectByid(Integer id);
	
	// ��ѯclienttype
	public List<C_clienttype> selectclienttype();
	
	// ��ѯoperator
	public List<C_operator> selectoperator();

	// ��ѯC_src
	public List<C_src> selectsrc();
	
	// ����
	public void insert(C_client b);
	
	// �޸�
	public void update(C_client b);
	
	// ɾ��
	public void delete(Integer b);
}
