package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Crm_customer;
import model.Crm_recode;
import model.Crm_sellman;

@Repository
public interface Crm_recode_Dao {

	// 查询
	@Select("select count(1) from Crm_recode")
	public int selectcount(@Param("where") String where);
	
	// 查询Crm_recode
	@Select("select Crm_recode.*,Crm_sellman.name sellname,crm_customer.csrname csrname from (Crm_recode inner join Crm_sellman on Crm_sellman.id=Crm_recode.smid) INNER JOIN crm_customer ON Crm_recode.cmid=crm_customer.id ${where} ${limit}")
	public List<Crm_recode> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询sellman
	@Select("select * from Crm_sellman")
	public List<Crm_sellman> selectsellman();
	
	// 查询customer
	@Select("select * from Crm_customer")
	public List<Crm_customer> selectcus();
	

	@Delete("delete from Crm_recode where id=#{id}")
	public void delete(Crm_recode id);

	 @Insert("insert into Crm_recode (date,smid,cmid,info,nextdate,status) values(#{date},#{smid},#{cmid},#{info},#{nextdate},#{status})")
	 public Integer insert(Crm_recode t);
	
	 @Update("update Crm_recode set date=#{date},smid=#{smid},cmid=#{cmid},info=#{info},nextdate=#{nextdate},status=#{status} where id=#{id}")
	 public Integer update(Crm_recode t);

}
