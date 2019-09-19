package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_reserved;
import model.C_revisit;
import utils.ReturnInfo;

public interface C_reserved_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_reserved
	public C_reserved selectByid(Integer id);
	
	// 查询C_revisit
	public List<C_revisit> selectrevisit();
	
	// 查询C_client
	public List<C_client> selectclient();	

	// 查询C_operator
	public List<C_operator> selectoperator();
	
	// 查询execoperator
	public List<C_operator> selectexecoperator();
	
	// 新增
	public void insert(C_reserved b);
	
	// 修改
	public void update(C_reserved b);
	
	// 删除
	public void delete(Integer b);
}
