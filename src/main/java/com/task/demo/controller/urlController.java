package com.task.demo.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.management.RuntimeErrorException;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.hash.Hashing;
import com.task.demo.service.shortUrlService;
import com.task.demo.service.trackService;

@RestController
@RequestMapping("/cricketpedia")
public class urlController {
	@Autowired
	StringRedisTemplate redisTemplate;
	@Autowired
	shortUrlService urlService;
	@Autowired
	trackService trackurl;
	 // for storing key value 
//shorten links get requests handle here
	@RequestMapping("/")
	public String home() {
		
		return "hello";
	}
	@GetMapping("/{id}")
	public RedirectView getUrl(@PathVariable String id) throws MalformedURLException {
		
	
		String OriginalUrl=redisTemplate.opsForValue().get(id);
		if(OriginalUrl==null) throw new RuntimeException("No Url shorten with this id"+id);
		else {
			return trackurl.trackUrl(OriginalUrl);
		}
	}
	
	// Shortening request handled here
	@PostMapping("/short/")
	public String shortUrl(@RequestBody String url) 
	{
		//validating urls
		
		 UrlValidator validator=new UrlValidator(new String[] {"http","https"});
		 
		 
		 if(validator.isValid(url)) 
		 {
			 String result=urlService.doShortUrl(url);
			 return result;
		 }
		 throw new RuntimeException("Url Invalid "+url);
		 
	}

}
