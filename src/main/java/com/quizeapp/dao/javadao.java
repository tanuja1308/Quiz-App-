package com.quizeapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizeapp.entities.qna;

@Repository
public interface javadao extends JpaRepository<qna,Integer>{
	/*
	 * @Query
	 * 
	 * List<qna> findByquesId(int s);
	 */
}
