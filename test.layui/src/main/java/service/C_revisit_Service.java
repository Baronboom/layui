package service;

import java.util.List;

import model.C_client;
import model.C_revisit;
import utils.ReturnInfo;

public interface C_revisit_Service {
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_revisit
	public C_revisit selectByid(Integer id);
	
	// ��ѯC_client
	public List<C_client> selectclient();
	
	// ����
	public void insert(C_revisit b);
	
	// �޸�
	public void update(C_revisit b);
	
	// ɾ��
	public void delete(Integer b);
}
