package service.Impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import service.BasicService;
import utils.ReturnInfo;

public class BasicServiceImpl<T> implements BasicService<T> {

	private Object execDao(String mname,Object... objs){
		try {
		Field f=this.getClass().getDeclaredField("dao");
		f.setAccessible(true);
		Object dao=f.get(this);
			
		Class cls=dao.getClass();  //  daoµÄ×Ö½ÚÂë
		Class[] cs=new Class[objs.length];
		for(int i=0;i<objs.length;i++)cs[i]=objs[i].getClass();
		Method m= cls.getMethod(mname, cs);
		m.setAccessible(true);
		return m.invoke(dao, objs);
		}catch (Exception e) {
			e .printStackTrace();
			return null;
		}
		
	}
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList((List) execDao("select", where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount((Integer)execDao("selectcount",where));
		  return info;
	}
	
	public T selectById(Integer id) {
		Object o=execDao("selectById",id);
		if(o!=null) return (T) o;
		else return null;
	}

	public List<T> selectType() {
		Object o=execDao("selectType");
		if(o!=null) return (List<T>) o;
		else return new ArrayList<T>();
	}

	public Integer insert(T t) {
		Object o=execDao("insert",t);
		if(o!=null) return (Integer) o;
		else return -2;
	}

	public Integer update(T t) {
		Object o=execDao("update",t);
		if(o!=null) return (Integer) o;
		else return -2;
	}

	public Integer delete(Integer id) {
		Object o=execDao("delete",id);
		if(o!=null) return (Integer) o;
		else return -2;
	}

}
