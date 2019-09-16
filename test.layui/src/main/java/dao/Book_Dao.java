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
	
	// ��ѯ
	@Select("select count(1) from book inner join type on type.id=book.typeid ${where}")
	public int selectcount(@Param("where") String where);
	
	// ��ѯ
	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid ${where} ${limit}")
	public List<Book> select(@Param("where") String where,@Param("limit") String limit);
	
	
	// ��ѯType
	@Select("select * from type")
	public List<Type> selectType();
	
	// ����
	@Insert("insert into book (name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public void insert(Book b);
	
	// �޸�
	@Update("update book set name=#{name},sex=#{sex},typeid=#{typeid} where id = #{id}")
	public void update(Book b);
	
	// ɾ��
	@Delete("delete from book where id = #{id}")
	public void delete(Book b);
	
}
