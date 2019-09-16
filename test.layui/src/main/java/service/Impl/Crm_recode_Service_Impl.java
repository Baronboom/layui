package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Crm_recode_Dao;
import model.Crm_customer;
import model.Crm_recode;
import model.Crm_sellman;
import service.Crm_recode_Service;
import utils.ReturnInfo;

@Service
public class Crm_recode_Service_Impl implements Crm_recode_Service{
	@Autowired
	Crm_recode_Dao dao;

	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where)); // dao.selectcount(where)
		return info;
	}

	public Crm_recode selectByid(Integer id) {
		return(Crm_recode) dao.select(" where Crm_recode.id="+id," limit 1").get(0);
	}

	public List<Crm_sellman> selectsellman() {
		return dao.selectsellman();
	}

	public List<Crm_customer> selectcus() {
		return dao.selectcus();
	}

	public void insert(Crm_recode b) {
		dao.insert(b);
	}

	public void update(Crm_recode b) {
		dao.update(b);
	}

	public void delete(Crm_recode b) {
		dao.delete(b);
	}

}
