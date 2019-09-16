package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import model.Book;
import model.Type;

@Repository
public interface Book_Dao {
	
	// 查询
	@Select("select count(1) from book inner join type on type.id=book.typeid ${where}")
	public int selectcount(@Param("where") String where);
	
	// 查询
	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid ${where} ${limit}")
	public List<Book> select(@Param("where") String where,@Param("limit") String limit);
	
	
	// 查询Type
	@Select("select * from type")
	public List<Type> selectType();
	
	// 新增
	@Insert("insert into book (name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public void insert(Book b);
	
	// 修改
	@Update("update book set name=#{name},sex=#{sex},typeid=#{typeid} where id = #{id}")
	public void update(Book b);
	
	// 删除
	@Delete("delete from book where id = #{id}")
	public void delete(Book b);
	
}
