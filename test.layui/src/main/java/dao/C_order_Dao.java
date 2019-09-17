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

@Repository
public interface C_order_Dao {
	
	// 查询
	@Select("select count(1) from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询C_order
	@Select("select C_order.*,C_client.name clientname,C_operator.name operatorname from (C_order inner join C_client on C_client.id=C_order.clientid) INNER JOIN c_operator ON C_order.operatorid=c_operator.id ${where} ${limit}")
	public List<C_order> select(@Param("where") String where,@Param("limit") String limit);
	
	// 查询operator
	@Select("select * from C_operator")
	public List<C_operator> selectoperator();
	
	// 查询C_client
	@Select("select * from C_client")
	public List<C_client> selectclient();
	
	@Delete("delete from C_order where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_order (name,clientid,createdate,compdate,orderdate,startdate,enddate,operatorid,info,files,compoperatorids,compweight,status,amount,comments) values(#{name},#{clientid},#{createdate},#{compdate},#{orderdate},#{startdate},#{enddate},#{operatorid},#{info},#{files},#{compoperatorids},#{compweight},#{status},#{amount},#{comments})")
	 public void insert(C_order t);

	 @Update("update C_order set name=#{name},clientid=#{clientid},createdate=#{createdate},compdate=#{compdate},orderdate=#{orderdate},startdate=#{startdate},enddate=#{enddate},operatorid=#{operatorid},info=#{info},files=#{files},compoperatorids=#{compoperatorids},compweight=#{compweight},status=#{status},amount=#{amount},comments=#{comments} where id=#{id}")
	 public void update(C_order t);


}
