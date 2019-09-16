package service;

import model.C_clienttype;
import utils.ReturnInfo;

public interface C_clienttype_Service {
	// 查询全部
		public ReturnInfo select(String where,Integer page,Integer max);
		
		// 查询一个
		public C_clienttype selectById(Integer id);
		
		// 新增
		public void insert(C_clienttype t);
		
		// 修改
		public void update(C_clienttype t);
		
		// 删除
		public void delete(Integer id);
}
