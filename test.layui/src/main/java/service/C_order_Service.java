package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_orderdetails;
import model.C_product;
import utils.ReturnInfo;

public interface C_order_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_order
	public C_order selectByid(Integer id);
	
	public C_orderdetails selecotByid(Integer id);
	
	// 查询operator
	public List<C_operator> selectoperator();
	
	// 查询C_client
	public List<C_client> selectclient();
	
	// 查询C_product
	public List<C_product> selectproduct();
	
	// 新增
	public void insert(C_order b);
	
	// 修改
	public void update(C_order b);
	
	// 删除
	public void delete(Integer b);
	
	public List<C_order> selectorder();
}
