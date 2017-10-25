package com.sirheadless.mybookmarks.url.controller;

import com.sirheadless.mybookmarks.authenticationfacade.AuthenticationFacade;
import com.sirheadless.mybookmarks.url.entity.Url;
import com.sirheadless.mybookmarks.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//@SpringBootApplication
//@EnableAutoConfiguration
@RestController
@RequestMapping("url")
public class UrlController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable("id") Integer id) {
        System.out.println("UrlController get Url for Id: " + id);
        Url url = urlService.getUrlById(id);
        return new ResponseEntity<Url>(url, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Url>> getAllUrls() {
        List<Url> list = urlService.getAllUrls();
        return new ResponseEntity<List<Url>>(list, HttpStatus.OK);
    }

    @GetMapping("all/{userId}")
    public ResponseEntity<List<Url>> getAllUrlsByUserId(@PathVariable("userId") Integer userId) {
        System.out.println("UrlController get all Urls for userId: " + userId);
        List<Url> list = urlService.getAllUrlsByUserId(userId);
        return new ResponseEntity<List<Url>>(list, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addArticle(@RequestBody Url url, UriComponentsBuilder builder) {
        Integer userId = authenticationFacade.getUserId();
        if (userId != null) {
            boolean flag = urlService.addUrl(url);
            if (flag == false) {
                return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
            HttpHeaders headers = new HttpHeaders();
//        	headers.setLocation(builder.path("/article/{id}").buildAndExpand(url.getUrlId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    //	@PutMapping("update")
//	public ResponseEntity<Url> updateArticle(@RequestBody Url url) {
//		urlService.updateUrl(url);
//		return new ResponseEntity<Url>(url, HttpStatus.OK);
//	}
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {

        ResponseEntity<Void> noAuthentication = checkAuthentication(id);
        if (noAuthentication != null) {
            return noAuthentication;
        }

        urlService.deleteUrl(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<Void> checkAuthentication(int id) {
        Integer userId = authenticationFacade.getUserId();
        if (userId != null) {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        Url url = urlService.getUrlById(id);
        if (url == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        if (url.getUserId() != userId) {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        return null;
    }
}
