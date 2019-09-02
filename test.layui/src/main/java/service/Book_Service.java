package service;

import java.util.List;


import model.Book;
import model.Type;
import utils.ReturnInfo;

public interface Book_Service {
	
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询Book
	public Book selectByid(Integer id);
	
	// 查询Type
	public List<Type> selectType();
	
	// 新增
	public void insert(Book b);
	
	// 修改
	public void update(Book b);
	
	// 删除
	public void delete(Book b);
}
