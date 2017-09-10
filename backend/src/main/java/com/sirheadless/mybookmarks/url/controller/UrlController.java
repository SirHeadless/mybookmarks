package com.sirheadless.mybookmarks.url.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sirheadless.mybookmarks.url.entity.UrlEntity;
import com.sirheadless.mybookmarks.url.service.UrlService;

@Controller
@RequestMapping("url")
public class UrlController {
	@Autowired
	private UrlService urlService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UrlEntity> getUrlById(@PathVariable("id") Integer id) {
		System.out.println("UrlController get Url for Id: " + id);
		UrlEntity urlEntity = urlService.getUrlById(id);
		return new ResponseEntity<UrlEntity>(urlEntity, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UrlEntity>> getAllUrls() {
		List<UrlEntity> list = urlService.getAllUrls();
		return new ResponseEntity<List<UrlEntity>>(list, HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<Void> addArticle(@RequestBody UrlEntity urlEntity, UriComponentsBuilder builder) {
        boolean flag = urlService.addUrl(urlEntity);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(urlEntity.getUrlId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("update")
	public ResponseEntity<UrlEntity> updateArticle(@RequestBody UrlEntity urlEntity) {
		urlService.updateUrl(urlEntity);
		return new ResponseEntity<UrlEntity>(urlEntity, HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		urlService.deleteUrl(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
