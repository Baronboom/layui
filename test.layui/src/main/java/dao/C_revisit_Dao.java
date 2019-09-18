package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_client;
import model.C_revisit;

@Repository
public interface C_revisit_Dao {
	
	// ≤È—Ø
	@Select("select count(1) from C_revisit inner join c_client on c_client.id=C_revisit.clientid ${where}")
	public int selectcount(@Param("where") String where);
	
	// ≤È—Ø
	@Select("select C_revisit.*,c_client.name clientname from C_revisit inner join c_client on c_client.id=C_revisit.clientid ${where} ${limit}")
	public List<C_revisit> select(@Param("where") String where,@Param("limit") String limit);

	// ≤È—Øclient
	@Select("select * from C_client")
	public List<C_client> selectclient();
	
	@Delete("delete from C_revisit where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_revisit (createdate,clientid,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,askinfo,followinfo,probleminfo,status,comments) values(#{createdate},#{clientid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	 public Integer insert(C_revisit t);

	 @Update("update C_revisit set createdate=#{createdate},clientid=#{clientid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	 public Integer update(C_revisit t);

}
