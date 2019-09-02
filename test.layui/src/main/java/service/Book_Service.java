package service;

import java.util.List;


import model.Book;
import model.Type;
import utils.ReturnInfo;

public interface Book_Service {
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯBook
	public Book selectByid(Integer id);
	
	// ��ѯType
	public List<Type> selectType();
	
	// ����
	public void insert(Book b);
	
	// �޸�
	public void update(Book b);
	
	// ɾ��
	public void delete(Book b);
}
