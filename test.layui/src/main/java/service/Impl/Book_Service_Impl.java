package service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_Dao;
import model.Book;
import model.Type;
import service.Book_Service;
import utils.ReturnInfo;

@Service
public class Book_Service_Impl extends BasicServiceImpl<Book> implements Book_Service{
	
	@Autowired
	Book_Dao dao;

//	public ReturnInfo select(String where, Integer page, Integer max) {
//		boolean canpage=page!=null;
//		ReturnInfo info = new ReturnInfo();
//		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
//		if(canpage)info.setCount(dao.selectcount(where));
//		  return info;
//	}
//
//	public Book selectById(Integer id) {
//		return  (Book) dao.select(" where book.id="+id," limit 1").get(0);
//	}
//
//	public void insert(Book b) {
//		dao.insert(b);
//	}
//
//	public void update(Book b) {
//		dao.update(b);
//	}
//
//	public void delete(Integer id) {
//		dao.delete(id);
//	}
//
//	public List<Type> selectType() {
//		return dao.selectType();
//	}

}
