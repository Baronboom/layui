package dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;
import model.Crm_customer;
import model.Crm_sellman;
import model.Type;

@Repository
public interface Crm_customer_Dao {
	
	
	// ��ѯ
	@Select("select count(1) from Crm_customer inner join Crm_sellman on Crm_sellman.id=Crm_customer.semid ${where}")
	public int selectcount(@Param("where") String where);

	// ��ѯCrm_customer
	@Select("select Crm_customer.*,Crm_sellman.sellname sellname from Crm_customer inner join Crm_sellman on Crm_sellman.id=Crm_customer.semid ${where} ${limit}")
	public List<Crm_customer> select(@Param("where") String where,@Param("limit") String limit);
	
	// ��ѯsellman
	@Select("select * from Crm_sellman")
	public List<Crm_sellman> selectsellman();
	
	// ����
	@Insert("insert into Crm_customer (csrname,csrtel,csrsta,semid) values(#{csrname},#{csrtel},#{csrsta},#{semid})")
	public void insert(Crm_customer b);
	
	// �޸�
	@Update("update Crm_customer set csrname=#{csrname},csrtel=#{csrtel},csrsta=#{csrsta},semid=#{semid} where id=#{id}")
	public void update(Crm_customer b);
	
	// ɾ��
	@Delete("delete from Crm_customer where id = #{id}")
	public void delete(Crm_customer b);
	
//	@Select("select Crm_customer.* from  Crm_customer ")
//	public  List<Crm_customer> getAll();
//
//	@Select("select Crm_customer.* from Crm_customer  where id=#{id}")
//	public  Crm_customer getByid(Integer id);
//
//	@Delete("delete from Crm_customer where id=#{id}")
//	public Integer delete(Integer id);

//	 @Insert("insert into Crm_customer (csrname,csrtel,csrsta,semid) values(#{csrname},#{csrtel},#{csrsta},#{semid})")
//	 public Integer insert(Crm_customer t);
//
//	 @Update("update Crm_customer set csrname=#{csrname},csrtel=#{csrtel},csrsta=#{csrsta},semid=#{semid} where id=#{id}")
//	 public Integer update(Crm_customer t);

}
