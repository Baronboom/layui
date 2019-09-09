package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.User;


@Repository
public interface User_Dao {
	
	// 登录方法
	@Select("select * from User where name = #{name} and pass = #{pass}")
	public User login(User u);
	
	// 查询全部
	@Select("select * from user ${where} ")
	public List<User> select(@Param("where") String where);

	// 查询一个
	@Select("select * from user where id=#{id}")
	public User selectById(int id);

	// 新增
	@Delete("delete from user where id=#{id} ")
	public void insert(User t);

	// 修改
	@Update("update user set name=#{name} where id=#{id}")
	public void update(User t);

	// 删除
	@Delete("delete from type where id=#{id} ")
	public void delete(int id);
}
