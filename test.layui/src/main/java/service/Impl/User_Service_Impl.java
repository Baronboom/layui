package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.User_Dao;
import model.User;
import service.User_Service;

@Service
public class User_Service_Impl implements User_Service{
	@Autowired
	User_Dao dao;
	
	// 查询全部
	public List<User> select(String where) {
		return dao.select(where);
	}

	// 查询一个
	public User selectById(int id) {
		return dao.selectById(id);
	}
	
	// 新增
	public void insert(User t) {
		dao.insert(t);
	}

	// 修改
	public void update(User t) {
		dao.update(t);
		
	}

	// 删除
	public void delete(int id) {
		dao.delete(id);
	}

	public User login(User u) {
		return dao.login(u);
	}

}
