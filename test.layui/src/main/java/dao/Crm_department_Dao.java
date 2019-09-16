package dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Crm_department;

@Repository
public interface Crm_department_Dao {

	// 查询
	@Select("select count(1) from Crm_department ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select * from Crm_department ${where} ${limit}")
	public List<Crm_department> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询一个
	@Select("select * from Crm_department where id=#{id}")
	public Crm_department selectById(Integer id);
	
	// 新增
	@Insert("insert into Crm_department (name) values(#{name})")
	public void insert(Crm_department t);
	
	// 修改
	@Update("update Crm_department set name=#{name} where id=#{id}")
	public void update(Crm_department t);
	
	// 删除
	@Delete("delete from Crm_department where id=#{id} ")
	public void delete(Integer id);
}
