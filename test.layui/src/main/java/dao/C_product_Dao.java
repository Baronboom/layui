package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_product;
import model.Type;

@Repository
public interface C_product_Dao {

	@Select("select count(1) from C_product ${where}")
	public int selectcount(@Param("where") String where);
	
	@Select("select * from C_product ${where} ${limit}")
	public List<C_product> select(@Param("where") String where,@Param("limit") String limit);

	// ²éÑ¯Ò»¸ö
	@Select("select * from C_product where id=#{id}")
	public C_product selectById(Integer id);
	
	@Delete("delete from C_product where id=#{id}")
	public void delete(Integer id);

	 @Insert("insert into C_product (name,amount,info) values(#{name},#{amount},#{info})")
	 public void insert(C_product t);

	 @Update("update C_product set name=#{name},amount=#{amount},info=#{info} where id=#{id}")
	 public void update(C_product t);

}
