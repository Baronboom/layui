package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_revisit;
import model.Status;
import utils.ReturnInfo;

public interface C_revisit_Service {
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_revisit
	public C_revisit selectByid(Integer id);
	// ��ѯoperator
	public List<C_operator> selectoperator();
	// ��ѯC_client
	public List<C_client> selectclient();
	
	// ����
	public void insert(C_revisit b);
	
	// �޸�
	public void update(C_revisit b);
	
	// �޸�Client
	public void updatec(Status b);
	
	// ɾ��
	public void delete(Integer b);
}
