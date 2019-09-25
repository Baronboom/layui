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
import model.C_revisit;
import model.Status;

@Repository
public interface C_revisit_Dao {
	
	// 查询
	@Select("select count(1) from (C_revisit inner join c_client on c_client.id=C_revisit.clientid)INNER JOIN c_operator on c_revisit.operatorid=c_operator.id ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select C_revisit.*,c_client.name clientname,c_operator.name operatorname from (C_revisit inner join c_client on c_client.id=C_revisit.clientid)INNER JOIN c_operator on c_revisit.operatorid=c_operator.id ${where} ${limit}")
	public List<C_revisit> select(@Param("where") String where,@Param("limit") String limit);

	// 查询client
	@Select("select * from C_client")
	public List<C_client> selectclient();
	
	// 查询operator
	@Select("select * from C_operator")
	public List<C_operator> selectoperator();
	
	@Delete("delete from C_revisit where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_revisit (operatorid,name,createdate,clientid,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,askinfo,followinfo,probleminfo,status,comments) values(#{operatorid},#{name},#{createdate},#{clientid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	 public void insert(C_revisit t);

	 @Update("update C_revisit set operatorid=#{operatorid},name=#{name},createdate=#{createdate},clientid=#{clientid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	 public void update(C_revisit t);
	 
	 @Update("update C_client set linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus} where id=#{id}")
	 public void updatec(Status b);

}
