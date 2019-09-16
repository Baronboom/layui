package service;

import model.C_product;
import utils.ReturnInfo;

public interface C_product_Service {
	// 查询全部
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询一个
	public C_product selectById(Integer id);
	
	// 新增
	public void insert(C_product t);
	
	// 修改
	public void update(C_product t);
	
	// 删除
	public void delete(Integer id);
}
