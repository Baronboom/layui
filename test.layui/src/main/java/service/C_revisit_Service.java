package service;

import java.util.List;

import model.C_client;
import model.C_operator;
import model.C_revisit;
import model.Status;
import utils.ReturnInfo;

public interface C_revisit_Service {
	
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_revisit
	public C_revisit selectByid(Integer id);
	// 查询operator
	public List<C_operator> selectoperator();
	// 查询C_client
	public List<C_client> selectclient();
	
	// 新增
	public void insert(C_revisit b);
	
	// 修改
	public void update(C_revisit b);
	
	// 修改Client
	public void updatec(Status b);
	
	// 删除
	public void delete(Integer b);
}
