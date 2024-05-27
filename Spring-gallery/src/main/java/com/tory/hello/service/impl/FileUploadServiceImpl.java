package com.tory.hello.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tory.hello.models.ImageVO;
import com.tory.hello.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	private final String folder;
	private final ServletContext context;
	
	public FileUploadServiceImpl(ServletContext context) {
		super();
		this.context = context;
		folder =context.getRealPath("/static/images");
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		// originalname getter
		String orifinalFileName = file.getOriginalFilename();
		
		// originalname 없으면 return null
		if(orifinalFileName.isEmpty()) {
			return null;
		}
		
		// 폴더 정보 객체 변환
		File path = new File(folder);
		
		// 폴더 검사, 없으면 생성
		if(!path.exists()) {
			path.mkdirs();
		}
		
		// uuid 만들기
		String uuid = UUID.randomUUID().toString();
		
		// originalName uuid 적용하기
		String upLoadFileName = String.format("%s-%s",uuid,orifinalFileName);
		
		// 폴더이름+파일이름 결합, 업로드할 파일 정보 생성
		File uploadFile = new File(folder, upLoadFileName);
		
		// file 업로드
		file.transferTo(uploadFile);
		// 저장된 파일 이름 return
		return upLoadFileName;
	}

	@Override
	public List<ImageVO> filesUpload(MultipartHttpServletRequest files) throws Exception {
		// files 의 이미지 파일 가져와서 list 만들기 (form input name 과 동일)
		List<MultipartFile> result = files.getFiles("multi");
		
		// single file 업로드에 쓸 ImageVO 리스트 만들기
		List<ImageVO> resultImages = new ArrayList<>();
		
		// for 확장문으로 리스트에있는 사진들 1개 업로드 method로 이름변형
		for(MultipartFile f : result) {
			String changeName = this.fileUpload(f);
			//  id, origin, up_image들 build 해서 resultImages 리스트에 추가
			resultImages.add(
					ImageVO.builder()
					.i_id(UUID.randomUUID().toString())
					.i_origin_image(f.getOriginalFilename())
					.i_up_image(changeName).build()
					);
		}
		// resultImages return
		return resultImages;
	}

}
