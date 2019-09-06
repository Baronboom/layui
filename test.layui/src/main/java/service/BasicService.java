package service;

import java.util.List;

import utils.ReturnInfo;

public interface BasicService<T> {
	
	// ��ѯ�ܵ�
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// ��ѯBook
	public T selectById(Integer id);
	
	// ��ѯType
	public List<T> selectType();
	
	// ����
	public Integer insert(T b);
	
	// �޸�
	public Integer update(T b);
	
	// ɾ��
	public Integer delete(Integer id);
}
