package service;

import model.C_clienttype;
import utils.ReturnInfo;

public interface C_clienttype_Service {
	// ��ѯȫ��
		public ReturnInfo select(String where,Integer page,Integer max);
		
		// ��ѯһ��
		public C_clienttype selectById(Integer id);
		
		// ����
		public void insert(C_clienttype t);
		
		// �޸�
		public void update(C_clienttype t);
		
		// ɾ��
		public void delete(Integer id);
}
