package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Type;

@Repository
public interface Type_Dao {
	// 查询
	@Select("select count(1) from type ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select * from type ${where} ${limit}")
	public List<Type> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询一个
	@Select("select * from type where id=#{id}")
	public Type selectById(Integer id);
	
	// 新增
	@Insert("insert into type (name) values(#{name})")
	public void insert(Type t);
	
	// 修改
	@Update("update type set name=#{name} where id=#{id}")
	public void update(Type t);
	
	// 删除
	@Delete("delete from type where id=#{id} ")
	public void delete(Integer id);
	
	@Select("select * from type")
	public List<Type> selectType();
	
}
