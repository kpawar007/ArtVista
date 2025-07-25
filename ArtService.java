package com.artapp.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.artapp.model.Art;
import com.artapp.repository.ArtRepository;


@Service
public class ArtService {
	
	@Autowired
	private ArtRepository repo;
	
	String uploadDir="C:/Users/jelly/OneDrive/Pictures/Desktop/kanhaiya project/Artvista/src/main/resources/static/images/";
	
	public String saveArt(Art artobj, MultipartFile file) {
		//Ensure the directory exists
		File diretcory = new File(uploadDir);
	
		String filePath = uploadDir + file.getOriginalFilename();
		
		System.out.println(diretcory.getPath());
			
			if(!diretcory.exists()) {
				diretcory.mkdirs();
			}
			
			System.out.println(filePath);
			
			
			try {
				file.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			artobj.setImageUrl("images/" + file.getOriginalFilename());
			repo.save(artobj);
			
			return "Art Object Saved";
	}
	
	public List<Art> getAllArt() {
		return repo.findAll(); // select * from Art;
	}
	
	public Art getArtById(int id) {
		return repo.findById(id).get(); // select * from Art where artId=?;
	}
	
	public String deleteArtById(int id) {
		repo.deleteById(id);
		return "delete";
	}
}
