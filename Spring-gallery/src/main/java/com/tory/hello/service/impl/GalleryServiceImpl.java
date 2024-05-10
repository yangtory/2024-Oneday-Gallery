package com.tory.hello.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tory.hello.dao.GalleryDao;
import com.tory.hello.dao.ImageDao;
import com.tory.hello.models.GalleryVO;
import com.tory.hello.models.ImageVO;
import com.tory.hello.service.FileUploadService;
import com.tory.hello.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {
	
	private final FileUploadService uploadService;
	private final GalleryDao galleryDao;
	private final ImageDao imageDao;

	public GalleryServiceImpl(FileUploadService uploadService, GalleryDao galleryDao, ImageDao imageDao) {
		super();
		this.uploadService = uploadService;
		this.galleryDao = galleryDao;
		this.imageDao = imageDao;
	}

	// single file
	@Override
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile file) throws Exception {
		// galleryVO originname 에 받아온 파일 originalname setting
		galleryVO.setG_origin_image(file.getOriginalFilename());
		
		// fileupload 하고 return 받은 변형된 이름 vo up_image 에 setting
		String fileName = uploadService.fileUpload(file) ;
		galleryVO.setG_up_image(fileName);
		
		// g_id uuid 로
		galleryVO.setG_id(UUID.randomUUID().toString());
		
		// insert 실행
		int result = galleryDao.insert(galleryVO);
		if(result > 0) {
			return galleryVO;
		}
		return null;
	}

	// multi files table 2개 insert
	@Override
	public List<GalleryVO> createGallerys(GalleryVO galleryVO, MultipartHttpServletRequest files) throws Exception {
		// g_id uuid 로 셋팅
		galleryVO.setG_id(UUID.randomUUID().toString());
		
		// 기본 이미지 정보 "" 으로
		galleryVO.setG_origin_image("");
		galleryVO.setG_up_image("");
		
		// mapper 에서 selectKey 설정한 g_id 값 가져오기
		String i_gid = galleryVO.getG_id();
		
		// gallery insert 실행
		galleryDao.insert(galleryVO);
		
		// resultnames 리스트 만들어서 multi업로드 실행해서 이름들 return 받기
		List<ImageVO> resultNames = uploadService.filesUpload(files);
		
		// image insert 실행
		imageDao.inserts(i_gid, resultNames);

		return null;
	}

	@Override
	public List<GalleryVO> selectAll() {
		return galleryDao.selectAll();
	}

}
