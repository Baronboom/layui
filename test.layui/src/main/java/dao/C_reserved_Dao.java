package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_client;
import model.C_operator;
import model.C_order;
import model.C_reserved;
import model.C_revisit;

@Repository
public interface C_reserved_Dao {

	
	// 查询
	@Select("select count(1) from (c_reserved inner join c_revisit on c_revisit.id=c_reserved.revisitid) INNER JOIN c_client ON c_reserved.clientid=c_client.id INNER JOIN c_operator on c_reserved.operatorid=c_operator.id ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询C_reserved
	@Select("select c_reserved.*,c_revisit.name revisitname,c_client.name clientname,c_operator.name operatorname,c_operator.name execoperatorname from (c_reserved inner join c_revisit on c_revisit.id=c_reserved.revisitid) INNER JOIN c_client ON c_reserved.clientid=c_client.id INNER JOIN c_operator on c_reserved.operatorid=c_operator.id ${where} ${limit}")
	public List<C_reserved> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询C_revisit
	@Select("select * from C_revisit")
	public List<C_revisit> selectrevisit();
	
	// 查询C_client
	@Select("select * from C_client")
	public List<C_client> selectclient();	

	// 查询C_operator
	@Select("select * from C_operator")
	public List<C_operator> selectoperator();
	
	// 查询execoperator
	@Select("select * from C_operator")
	public List<C_operator> selectexecoperator();
	
	
	@Delete("delete from C_reserved where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_reserved (revisitid,clientid,createdate,operatorid,date,execoperatorid,type,status,execstatsu,result) values(#{revisitid},#{clientid},#{createdate},#{operatorid},#{date},#{execoperatorid},#{type},#{status},#{execstatsu},#{result})")
	 public void insert(C_reserved t);

	 @Update("update C_reserved set revisitid=#{revisitid},clientid=#{clientid},createdate=#{createdate},operatorid=#{operatorid},date=#{date},execoperatorid=#{execoperatorid},type=#{type},status=#{status},execstatsu=#{execstatsu},result=#{result} where id=#{id}")
	 public void update(C_reserved t);

}
