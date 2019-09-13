package com.metacube.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.dao.PassDao;
import com.metacube.model.pojo.Pass;
import com.metacube.service.PassService;
@Service
public class PassServiceImpl implements PassService {
	@Autowired
	private PassDao passDao;
	
	@Override
	public boolean addPass(Pass pass) {
		return passDao.addPass(pass);
	}

}
