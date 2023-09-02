package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBbsDto;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao{
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public List<SimpleBbsDto> listDao() {
		System.out.println("listDao()....");		
		String sql = "select * from simple_bbs order by id desc";
		List<SimpleBbsDto> list = jt.query(sql, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));		
		return list;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("viewDao()....");		
		String sql = "select * from simple_bbs where id = " + id;
		SimpleBbsDto dto = jt.queryForObject(sql, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));		
		return dto;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()....");		
		String sql = "insert into simple_bbs (writer , title , content) values (? , ? , ?)";
		return jt.update(sql, writer, title, content);
	}
	
	@Override
	public int writeDao2(SimpleBbsDto simpleBbsDto) {
		System.out.println("writeDao2()....");		
		String sql = "insert into simple_bbs (writer , title , content) values (? , ? , ?)";
		return jt.update(sql, simpleBbsDto.getWriter(), simpleBbsDto.getTitle(), simpleBbsDto.getContent());
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()....");		
		String sql = "delete from simple_bbs where id = ?";
		return jt.update(sql, Integer.parseInt(id));
	}	
	
}