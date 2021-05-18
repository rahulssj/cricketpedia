package com.task.demo;

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

@RestController
@RequestMapping("/cricketpedia/")
public class urlController {
	@Autowired
	StringRedisTemplate redisTemplate; // for storing key value 
//shorten links get requests handle here
	@GetMapping("/{id}")
	public RedirectView getUrl(@PathVariable String id) throws MalformedURLException {
		
	
		String OriginalUrl=redisTemplate.opsForValue().get(id);
		if(OriginalUrl==null) throw new RuntimeException("No Url shorten with this id"+id);
		else {
		URL url=new URL(OriginalUrl);
		String query=url.getQuery();
		String link="/track?"+query;
		System.out.println(query);
		System.out.println(OriginalUrl);
		System.out.println(link);
		RedirectView redirectView = new RedirectView();
	       redirectView.setUrl(link);
	 
		return redirectView;}
	}
	
	// Shortening request handled here
	@PostMapping("/short/")
	public String shortUrl(@RequestBody String url) 
	{
		//validating urls
		
		 UrlValidator validator=new UrlValidator(new String[] {"http","https"});
		 
		 
		 if(validator.isValid(url)) 
		 {
		String id= Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		if(redisTemplate.opsForValue().get(id)==null) {

			redisTemplate.opsForValue().set(id, url);
			 return "shorten link is: " + id;			
		}
		else return "shorten link is: " + id;
		
		 }
		 throw new RuntimeException("Url Invalid "+url);
		 
	}

}
