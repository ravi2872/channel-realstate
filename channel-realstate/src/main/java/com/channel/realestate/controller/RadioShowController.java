package com.channel.realestate.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.channel.realestate.dto.RadioShowDto;
import com.channel.realestate.dto.RadioShows;
import com.channel.realestate.service.DBFileStorageService;

@RestController
@RequestMapping("/radioshows")
public class RadioShowController {
	
	@Autowired
	DBFileStorageService service;
	
	@PostMapping
    public String createRadioShow(@RequestParam("file") MultipartFile file, @RequestParam("category") String category) throws IOException {
		RadioShows storedFile = service.storeFile(category, file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(""+storedFile.getPkey())
                .toUriString();

        return "Success "+fileDownloadUri;
    }
	
	@GetMapping
	public List<RadioShowDto> getAllRadioShows() throws IOException{
		List<RadioShowDto> list = service.getAllRadioShows();
		return list;
		
	}
}
