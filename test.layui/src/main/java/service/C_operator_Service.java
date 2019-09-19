package service;

import java.util.List;

import model.C_operator;
import model.C_workgroup;
import model.User;
import utils.ReturnInfo;

public interface C_operator_Service {
	
	public C_operator login(C_operator u);
	
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_operator
	public C_operator selectByid(Integer id);
	
	// 查询C_workgroup
	public List<C_workgroup> selectWorkgroup();
	
	// 新增
	public void insert(C_operator b);
	
	// 修改
	public void update(C_operator b);
	
	// 删除
	public void delete(Integer b);

}
