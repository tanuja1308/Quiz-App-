package com.quizeapp.service;

import java.util.List;

import com.quizeapp.entities.contactform;
import com.quizeapp.entities.qna;
import com.quizeapp.entities.qnaangular;
import com.quizeapp.entities.qnapython;
import com.quizeapp.entities.qnaspring;
import com.quizeapp.entities.qnasql;
import com.quizeapp.entities.qnaweb;

public interface quizeintr {

	public List<qna> javashowAll();
	public List<qnasql> sqlshowAll();
	public List<qnaangular> angularshowAll();
	public List<qnaweb> webshowAll();
	public List<qnapython> pythonshowAll();
	public List<qnaspring> springshowAll();
	public contactform saveinfo();
	
}
