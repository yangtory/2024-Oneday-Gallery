package com.tory.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tory.hello.models.ImageVO;

public interface ImageDao {
	
	// 1개의 g_id, 여러개의 names insert 
	public int inserts(@Param("g_id") String i_gid,
			@Param("images") List<ImageVO> resultNames);
}
