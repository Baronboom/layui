package dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Crm_department;
import model.Crm_sellman;

@Repository
public interface Crm_sellman_Dao {

	// ��ѯ
	@Select("select count(1) from Crm_sellman ${where}")
	public int selectcount(@Param("where") String where);
	
	// ��ѯ
	@Select("select Crm_sellman.*,Crm_department.name depname from Crm_sellman inner join Crm_department on Crm_sellman.depid=Crm_department.id ${where} ${limit}")
	public List<Crm_sellman> select(@Param("where") String where,@Param("limit") String limit);
	
	// ��ѯһ��
	@Select("select * from Crm_sellman where id=#{id}")
	public Crm_sellman selectById(Integer id);
	
	// ��ѯCrm_department
	@Select("select * from Crm_department")
	public List<Crm_department> selectDeps();
	
	// ����
	@Insert("insert into Crm_sellman (name,depid) values(#{name},#{depid})")
	public void insert(Crm_sellman t);
	
	// �޸�
	@Update("update Crm_sellman set name=#{name},depid=#{depid} where id=#{id}")
	public void update(Crm_sellman t);
	
	// ɾ��
	@Delete("delete from Crm_sellman where id=#{id} ")
	public void delete(Integer id);
}
