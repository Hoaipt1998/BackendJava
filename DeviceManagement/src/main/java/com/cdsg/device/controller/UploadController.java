package com.cdsg.device.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

	// Save the uploaded file to this folder
	// private static String UPLOADED_FOLDER = "F://Temp//";

	@Value("${file.upload-dir}")
	private String UPLOADED_FOLDER;

	@Autowired
	private ServletContext servletContext;

	@GetMapping("/upload")
	public String index() {
		return "upload";
	}

	@PostMapping("/uploadSave")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "uploadStatus";
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			// Get the current path
			// Store file in the folder /WEB-INF/storefiles/
			System.out.println(servletContext.getRealPath("/WEB-INF/storefiles/").toString());
			path = Paths
					.get(servletContext.getRealPath("/WEB-INF/storefiles/").toString() + file.getOriginalFilename());
			Files.write(path, bytes);

			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
		Path fileStorageLocation = Paths.get(servletContext.getRealPath("/WEB-INF/storefiles/").toString());
		try {
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new FileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new FileNotFoundException("File not found " + fileName + ex.getMessage());
		}
	}

	@GetMapping("/storefiles/{fileName:.+}")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) {
		String dataDirectory = UPLOADED_FOLDER;
		Path file = Paths.get(dataDirectory, fileName);
		System.out.println("Download file");
		if (Files.exists(file)) {
			// response.setContentType("application/txt");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}