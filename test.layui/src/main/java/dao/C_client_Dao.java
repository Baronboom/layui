package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_client;
import model.C_clienttype;
import model.C_operator;
import model.C_src;

@Repository
public interface C_client_Dao {

	// 查询
	@Select("select count(1) from (c_client inner join c_clienttype on C_client.clienttypeid=c_clienttype.id)INNER JOIN c_src ON c_client.srcid=c_src.id INNER JOIN c_operator ON c_client.createoperatorid=c_operator.id ${where}")
	public int selectcount(@Param("where") String where);
	
	
	// 查询C_client
	@Select("select c_client.*,c_clienttype.name clienttypename,c_src.name srcname,c_operator.name createoperatorname from (c_client inner join c_clienttype on C_client.clienttypeid=c_clienttype.id)INNER JOIN c_src ON c_client.srcid=c_src.id INNER JOIN c_operator ON c_client.createoperatorid=c_operator.id ${where} ${limit}")
	public List<C_client> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询clienttype
	@Select("select * from C_clienttype")
	public List<C_clienttype> selectclienttype();
	
	// 查询operator
	@Select("select * from C_operator")
	public List<C_operator> selectoperator();

	// 查询C_src
	@Select("select * from C_src")
	public List<C_src> selectsrc();
	
	
	@Delete("delete from C_client where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_client (name,sex,tel,qq,email,infos,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,status,clienttypeid,operatorids,createoperatorid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{infos},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{status},#{clienttypeid},#{operatorids},#{createoperatorid},#{createdate},#{srcid},#{count},#{comments})")
	 public void insert(C_client t);

	 @Update("update C_client set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},email=#{email},infos=#{infos},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},status=#{status},clienttypeid=#{clienttypeid},operatorids=#{operatorids},createoperatorid=#{createoperatorid},createdate=#{createdate},srcid=#{srcid},count=#{count},comments=#{comments} where id=#{id}")
	 public void update(C_client t);

}
