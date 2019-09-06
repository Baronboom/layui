package service;

import java.util.List;

import utils.ReturnInfo;

public interface BasicService<T> {
	
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询Book
	public T selectById(Integer id);
	
	// 查询Type
	public List<T> selectType();
	
	// 新增
	public Integer insert(T b);
	
	// 修改
	public Integer update(T b);
	
	// 删除
	public Integer delete(Integer id);
}
