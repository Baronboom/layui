package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_workgroup;

@Repository
public interface C_workgroup_Dao {
	// 查询
	@Select("select count(1) from C_workgroup ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select * from C_workgroup ${where} ${limit}")
	public List<C_workgroup> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询一个
	@Select("select * from C_workgroup where id=#{id}")
	public C_workgroup selectById(int id);
	
	// 新增
	@Insert("insert into C_workgroup (name) values(#{name})")
	public void insert(C_workgroup t);
	
	// 修改
	@Update("update C_workgroup set name=#{name} where id=#{id}")
	public void update(C_workgroup t);
	
	// 删除
	@Delete("delete from C_workgroup where id=#{id} ")
	public void delete(Integer id);
}
