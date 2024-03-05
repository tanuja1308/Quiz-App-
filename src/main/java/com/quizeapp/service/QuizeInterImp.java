package com.quizeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizeapp.dao.angulardao;
import com.quizeapp.dao.javadao;
import com.quizeapp.dao.pythondao;
import com.quizeapp.dao.springdao;
import com.quizeapp.dao.sqldao;
import com.quizeapp.dao.webdao;
import com.quizeapp.entities.contactform;
import com.quizeapp.entities.qna;
import com.quizeapp.entities.qnaangular;
import com.quizeapp.entities.qnapython;
import com.quizeapp.entities.qnaspring;
import com.quizeapp.entities.qnasql;
import com.quizeapp.entities.qnaweb;

@Service
public class QuizeInterImp implements quizeintr{

	@Autowired
	javadao qr;
	
	@Autowired
	sqldao sd;
	
	@Autowired
	pythondao pd;
	
	@Autowired
	springdao spd;
	
	@Autowired
	angulardao ad;

	@Autowired
	webdao wd;

	
	
	@Override
	public List<qna> javashowAll() {
		return this.qr.findAll();
	}

	@Override
	public List<qnasql> sqlshowAll() {

		return this.sd.findAll();
	}

	@Override
	public List<qnaangular> angularshowAll() {
		return this.ad.findAll();
	}

	@Override
	public List<qnaweb> webshowAll() {
		return this.wd.findAll();
	}

	@Override
	public List<qnapython> pythonshowAll() {
		return this.pd.findAll();
	}

	@Override
	public List<qnaspring> springshowAll() {
		return this.spd.findAll();
	}

	@Override
	public contactform saveinfo() {
		
		return null;
	}
	


}
