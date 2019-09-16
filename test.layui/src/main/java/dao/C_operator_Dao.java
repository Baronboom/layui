package dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_operator;
import model.C_workgroup;

@Repository
public interface C_operator_Dao {

	// ≤È—Ø
	@Select("select count(1) from C_operator inner join C_workgroup on C_workgroup.id=C_operator.groupid ${where}")
	public int selectcount(@Param("where") String where);
	
	// ≤È—Ø
	@Select("select C_operator.*,C_workgroup.name groupname from C_operator inner join C_workgroup on C_workgroup.id=C_operator.groupid ${where} ${limit}")
	public List<C_operator> select(@Param("where") String where,@Param("limit") String limit);
	
	// ≤È—ØC_workgroup
	@Select("select * from C_workgroup")
	public List<C_workgroup> selectWorkgroup();
	
	@Delete("delete from C_operator where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_operator (name,pass,tel,groupid,power,status) values(#{name},#{pass},#{tel},#{groupid},#{power},#{status})")
	 public void insert(C_operator t);

	 @Update("update C_operator set name=#{name},pass=#{pass},tel=#{tel},groupid=#{groupid},power=#{power},status=#{status} where id=#{id}")
	 public void update(C_operator t);

}
