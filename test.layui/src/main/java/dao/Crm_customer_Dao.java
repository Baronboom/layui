package dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Crm_customer;
import model.Crm_sellman;

@Repository
public interface Crm_customer_Dao {
	
	
	// 查询
	@Select("select count(1) from Crm_customer inner join Crm_sellman on Crm_sellman.id=Crm_customer.semid ${where}")
	public int selectcount(@Param("where") String where);

	// 查询Crm_customer
	@Select("select Crm_customer.*,Crm_sellman.name sellname from Crm_customer inner join Crm_sellman on Crm_sellman.id=Crm_customer.semid ${where} ${limit}")
	public List<Crm_customer> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询sellman
	@Select("select * from Crm_sellman")
	public List<Crm_sellman> selectsellman();
	
	// 新增
	@Insert("insert into Crm_customer (csrname,csrtel,csrsta,semid) values(#{csrname},#{csrtel},#{csrsta},#{semid})")
	public void insert(Crm_customer b);
	
	// 修改
	@Update("update Crm_customer set csrname=#{csrname},csrtel=#{csrtel},csrsta=#{csrsta},semid=#{semid} where id=#{id}")
	public void update(Crm_customer b);
	
	// 删除
	@Delete("delete from Crm_customer where id = #{id}")
	public void delete(Crm_customer b);
	
}
