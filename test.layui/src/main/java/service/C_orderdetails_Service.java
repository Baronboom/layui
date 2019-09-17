package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import utils.ReturnInfo;

public interface C_orderdetails_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_order
	public C_orderdetails selectByid(Integer id);
	
	// 查询C_product
	public List<C_product> selectproduct();
	
	// 查询C_order
	public List<C_order> selectorder();
	
	// 新增
	public void insert(C_orderdetails b);
	
	// 修改
	public void update(C_orderdetails b);
	
	// 删除
	public void delete(Integer id);
}
