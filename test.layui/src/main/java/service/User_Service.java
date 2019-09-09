package service;

import java.util.List;

import model.User;


public interface User_Service {
	
	public User login(User u);
	
	// 查询全部
	public List<User> select(String where);
	
	// 查询一个
	public User selectById(int id);
	
	// 新增
	public void insert(User t);
	
	// 修改
	public void update(User t);
	
	// 删除
	public void delete(int id);
}
