package com.tory.hello.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tory.hello.models.GalleryVO;

public interface GalleryService {
	
	public List<GalleryVO> selectAll();
	
	// 1개 파일
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile file) throws Exception; 
	
	// 여러개 파일
	public List<GalleryVO> createGallerys(GalleryVO galleryVO,
			MultipartHttpServletRequest files) throws Exception;
}
