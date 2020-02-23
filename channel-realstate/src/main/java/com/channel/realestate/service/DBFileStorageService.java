package com.channel.realestate.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.channel.realestate.dto.RadioShowDto;
import com.channel.realestate.dto.RadioShows;
import com.channel.realestate.repository.RadioShowsRepository;

@Service
public class DBFileStorageService {

	@Autowired
	private RadioShowsRepository repository;

	private final String PATH = "E:\\Test\\";
	public RadioShows storeFile(String category, MultipartFile file) throws IOException {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		new File(PATH+fileName);
		Files.copy(file.getInputStream(), Paths.get(PATH+fileName), StandardCopyOption.REPLACE_EXISTING);
		RadioShows radioShows = new RadioShows();
		radioShows.setAudioLink(PATH+file.getOriginalFilename());
		radioShows.setCategory(category);
//		// Check if the file's name contains invalid characters
//		if (fileName.contains("..")) {
////                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//		}

		return repository.save(radioShows);
	}
	
	public List<RadioShowDto> getAllRadioShows() throws IOException{
		List<RadioShows> list = repository.findAll();
		List<RadioShowDto> returnList = new ArrayList<RadioShowDto>();
		for (RadioShows radioShow : list) {
			RadioShowDto dto = new RadioShowDto(radioShow.getCategory(), Files.readAllBytes(Paths.get(radioShow.getAudioLink())));
			returnList.add(dto);
		}
		return returnList;
		
	}

}
