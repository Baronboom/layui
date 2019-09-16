package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_clienttype;

@Repository
public interface C_clienttype_Dao {
	// 查询
	@Select("select count(1) from C_clienttype ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select * from C_clienttype ${where} ${limit}")
	public List<C_clienttype> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询一个
	@Select("select * from C_clienttype where id=#{id}")
	public C_clienttype selectById(int id);
	
	// 新增
	@Insert("insert into C_clienttype (name) values(#{name})")
	public void insert(C_clienttype t);
	
	// 修改
	@Update("update C_clienttype set name=#{name} where id=#{id}")
	public void update(C_clienttype t);
	
	// 删除
	@Delete("delete from C_clienttype where id=#{id} ")
	public void delete(Integer id);
}
