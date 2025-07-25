package com.artapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.artapp.model.Art;
import com.artapp.service.ArtService;
import jakarta.validation.Valid;

@Controller
public class ArtController {
	
	@Autowired
	private ArtService service;
	
	@GetMapping("/")
	public ModelAndView displayindex() {
		return  new ModelAndView("index","art",new Art());
	}
	
	@GetMapping("/showaddartform")
	public ModelAndView displayAddArtForm() {
		return new ModelAndView("addart","art",new Art());
	}
	
	@PostMapping("/save")
	public String SaveArt(@Valid @ModelAttribute Art art, @RequestParam("file") MultipartFile file) {
		String msg = service.saveArt(art, file);
		System.out.println((msg));
		return "addart";
	}
	
	@GetMapping("/artList")
	public ModelAndView displayArtList() {
		
		List<Art> artList=service.getAllArt();
		return new ModelAndView("ArtList", "alist", artList);
		
	}
	
	@PostMapping("/update")
	public String updateArt(@Valid @ModelAttribute Art art, @RequestParam("file") MultipartFile file) {
		String msg = service.saveArt(art, file);
		System.out.println((msg));
		return "artList";
	}
	
	@GetMapping("/editart")
	public ModelAndView showUpdateForm(@RequestParam("artId") int artId) {
		Art art = service.getArtById(artId);
		return new ModelAndView("updateart", "art", art);
	}
	
	@GetMapping("/deleteart")
	public String deleteArt(@RequestParam("artId") int artId) {
		service.deleteArtById(artId);
		return "ArtList";
	}
}
