package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_reserved;
import model.C_revisit;
import utils.ReturnInfo;

public interface C_reserved_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_reserved
	public C_reserved selectByid(Integer id);
	
	// ��ѯC_revisit
	public List<C_revisit> selectrevisit();
	
	// ��ѯC_client
	public List<C_client> selectclient();	

	// ��ѯC_operator
	public List<C_operator> selectoperator();
	
	// ��ѯexecoperator
	public List<C_operator> selectexecoperator();
	
	// ����
	public void insert(C_reserved b);
	
	// �޸�
	public void update(C_reserved b);
	
	// ɾ��
	public void delete(Integer b);
}
