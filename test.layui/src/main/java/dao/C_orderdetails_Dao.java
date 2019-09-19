package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_order;
import model.C_orderdetails;
import model.C_product;

@Repository
public interface C_orderdetails_Dao {

	
	// 查询
	@Select("select count(1) from (C_orderdetails inner join C_product on C_product.id=C_orderdetails.productid) INNER JOIN C_order ON C_orderdetails.orderid=C_order.id ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询C_orderdetails
	@Select("select C_orderdetails.*,C_product.name productname,C_order.name ordername from (C_orderdetails inner join C_product on C_product.id=C_orderdetails.productid) INNER JOIN C_order ON C_orderdetails.orderid=C_order.id ${where} ${limit}")
	public List<C_orderdetails> select(@Param("where") String where,@Param("limit") String limit);
	
	
	// 查询C_product
	@Select("select * from C_product")
	public List<C_product> selectproduct();
	
	// 查询C_order
	@Select("select * from C_order")
	public List<C_order> selectorder();
	
	@Delete("delete from C_orderdetails where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_orderdetails (orderid,productid,count,amount,desca,comments) values(#{orderid},#{productid},#{count},#{amount},#{desca},#{comments})")
	 public void insert(C_orderdetails t);

	 @Update("update C_orderdetails set orderid=#{orderid},productid=#{productid},count=#{count},amount=#{amount},desca=#{desca},comments=#{comments} where id=#{id}")
	 public void update(C_orderdetails t);

}
