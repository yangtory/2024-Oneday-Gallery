package com.tory.hello.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tory.hello.models.ImageVO;


public interface FileUploadService {
	
	// 한 개 파일
	public String fileUpload(MultipartFile file) throws Exception;
	
	// 여러 개 파일
	public List<ImageVO> filesUpload(MultipartHttpServletRequest files) throws Exception;
}
