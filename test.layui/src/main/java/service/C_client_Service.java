package service;

import java.util.List;
import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_revisit;
import model.C_src;
import model.Status;
import model.fenpei;
import model.plfenpei;
import utils.ReturnInfo;

public interface C_client_Service {
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯC_client
	public C_client selectByid(Integer id);
	
	// ��ѯclienttype
	public List<C_clienttype> selectclienttype();
	// ��ѯC_client
	public List<C_client> selectclient();
	// ��ѯoperator
	public List<C_operator> selectoperator();

	// ��ѯC_src
	public List<C_src> selectsrc();
	
	// ����
	public void insert(C_client b);
	
	// �޸�
	public void update(C_client b);	
	// �·��� �ط�
	public void inserthf(C_revisit b);
	// �޸�
	public void updateo(fenpei b);
	// �޸�Client
	public void updatec(Status b);
	// �޸�
	public void updateopl(plfenpei b);

	// ɾ��
	public void delete(Integer b);
	
	// ���µ�������
	public void updateonpl(Integer b);
	
	// �ӹ����ط�����Լ�
	public void updatepubpl(plfenpei b);
	
	// ʵ�ֻطô�����һ
	public Integer counthf(Integer id);
}
