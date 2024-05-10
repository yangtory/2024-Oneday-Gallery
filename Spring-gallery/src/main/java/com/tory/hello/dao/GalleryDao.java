package com.tory.hello.dao;

import java.util.List;

import com.tory.hello.models.GalleryVO;

public interface GalleryDao {
	public List<GalleryVO>selectAll();

	public int insert(GalleryVO vo);

}
