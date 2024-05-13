package com.tory.hello.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tory.hello.models.GalleryVO;
import com.tory.hello.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final GalleryService galleryService;
	
	public HomeController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		List<GalleryVO> result = galleryService.selectAll();
		log.debug("갤러리 {}", result);
		model.addAttribute("LIST", result);
		model.addAttribute("BODY", "GALLERY_LIST");
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY", "GALLERY_INSERT");
		return "layout";
	}
	
	@Transactional
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO,
			@RequestParam("file") MultipartFile file,
			MultipartHttpServletRequest files, Model model) {
		// singleFileName  가져오기
		log.debug("파일이름 {}", file.getOriginalFilename());
		String singleName = file.getOriginalFilename();
		
		GalleryVO vo = null;
		try {
			// singleName 이 비어있으면 1개 업로드,
			if(!singleName.isEmpty()) {
				vo = galleryService.createGallery(galleryVO, file);
			}
			
			// multifile 인 경우 여러개 업로드
			if(files.getFiles("multi").size() > 0) {
				List<GalleryVO> multiVO = galleryService.createGallerys(galleryVO, files);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("BODY", "GALLERY_INSERT");
		return "layout";
	}
	
}
