package service;

import java.util.List;
import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_src;
import utils.ReturnInfo;

public interface C_client_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_client
	public C_client selectByid(Integer id);
	
	// 查询clienttype
	public List<C_clienttype> selectclienttype();
	
	// 查询operator
	public List<C_operator> selectoperator();

	// 查询C_src
	public List<C_src> selectsrc();
	
	// 新增
	public void insert(C_client b);
	
	// 修改
	public void update(C_client b);
	
	// 删除
	public void delete(Integer b);
}
