package service;

import java.util.List;
import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_revisit;
import model.C_src;
import model.Status;
import model.fenpei;
import model.plfenpei;
import utils.ReturnInfo;

public interface C_client_Service {
	// 查询总的
	public ReturnInfo select(String where,Integer page,Integer max);
	
	// 查询C_client
	public C_client selectByid(Integer id);
	
	// 查询clienttype
	public List<C_clienttype> selectclienttype();
	// 查询C_client
	public List<C_client> selectclient();
	// 查询operator
	public List<C_operator> selectoperator();

	// 查询C_src
	public List<C_src> selectsrc();
	
	// 新增
	public void insert(C_client b);
	
	// 修改
	public void update(C_client b);	
	// 新分配 回访
	public void inserthf(C_revisit b);
	// 修改
	public void updateo(fenpei b);
	// 修改Client
	public void updatec(Status b);
	// 修改
	public void updateopl(plfenpei b);

	// 删除
	public void delete(Integer b);
	
	// 更新到公共池
	public void updateonpl(Integer b);
	
	// 从公共池分配给自己
	public void updatepubpl(plfenpei b);
	
	// 实现回访次数加一
	public Integer counthf(Integer id);
}
