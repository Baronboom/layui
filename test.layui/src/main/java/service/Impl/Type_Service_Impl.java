package service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Type_Dao;
import model.Book;
import model.Type;
import service.Book_Service;
import service.Type_Service;
import utils.ReturnInfo;

@Service
public class Type_Service_Impl extends BasicServiceImpl<Type> implements  Type_Service{
	@Autowired
	Type_Dao dao;
	
//	// 查询全部
//	public ReturnInfo select(String where, Integer page, Integer max) {
//		boolean canpage=page!=null;
//		ReturnInfo info = new ReturnInfo();
//		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
//		if(canpage)info.setCount(dao.selectcount(where));
//		  return info;
//	}
//
//	// 查询一个
//	public Type selectById(Integer id) {
//		return dao.selectById(id);
//	}
//	
//	// 新增
//	public void insert(Type t) {
//		dao.insert(t);
//	}
//
//	// 修改
//	public void update(Type t) {
//		dao.update(t);
//		
//	}
//
//	// 删除
//	public void delete(Integer id) {
//		dao.delete(id);
//	}


}
