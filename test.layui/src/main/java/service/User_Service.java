package service;

import java.util.List;

import model.User;


public interface User_Service {
	
	public User login(User u);
	
	// ��ѯȫ��
	public List<User> select(String where);
	
	// ��ѯһ��
	public User selectById(int id);
	
	// ����
	public void insert(User t);
	
	// �޸�
	public void update(User t);
	
	// ɾ��
	public void delete(int id);
}
