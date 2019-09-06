package controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Impl.BasicServiceImpl;
import utils.ReturnInfo;
import utils.ReturnJson;

public class BasicController<T> {
	BasicServiceImpl<T> basicservice;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f=this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object dao=f.get(this);
		basicservice=(BasicServiceImpl<T>) dao;
	}
	
	private String getTname() {
		return getRealType().getSimpleName();
	}
	
	public Class getRealType(){
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	
	@GetMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit,ModelMap m) {
		System.out.println("basic_index");
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		return basicservice.select(txt,page,limit);
	}
	@GetMapping("edit/{id}")
	public @ResponseBody T edit(@PathVariable("id") Integer id,ModelMap m) {
		return basicservice.selectById(id);
	}
	
	
	
	@PostMapping("insert")
	public @ResponseBody ReturnJson insert( T t,ModelMap m) {
		basicservice.insert(t);
		return new ReturnJson();
	}
	
	@DeleteMapping("{id}")
	public @ResponseBody ReturnJson delete(@PathVariable("id") int id,ModelMap m) {
		basicservice.delete(id);
       return new ReturnJson();
	}
	
	@PutMapping("{id}")
	public @ResponseBody ReturnJson update(T t,ModelMap m) {
		basicservice.update(t);
		return new ReturnJson();
	}


}
