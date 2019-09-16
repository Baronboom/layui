package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Crm_customer_Dao;
import model.Book;
import model.Crm_customer;
import model.Crm_sellman;
import service.Crm_customer_Service;
import utils.ReturnInfo;

@Service
public class Crm_customer_Service_Impl implements Crm_customer_Service {
	
	@Autowired
	Crm_customer_Dao dao;

	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public Crm_customer selectByid(Integer id) {
		return  (Crm_customer) dao.select(" where Crm_customer.id="+id," limit 1").get(0);
	}

	public List<Crm_sellman> selectsellman() {
		return dao.selectsellman();
	}

	public void insert(Crm_customer b) {
		dao.insert(b);
	}

	public void update(Crm_customer b) {
		dao.update(b);
	}

	public void delete(Crm_customer b) {
		dao.delete(b);
	}

}
