package com.task.demo.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
@Service
public class shortUrlService {
	@Autowired
	StringRedisTemplate redisTemplate;
	
	public String doShortUrl(String url) {
		String id= Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		if(redisTemplate.opsForValue().get(id)==null) {

			redisTemplate.opsForValue().set(id, url);
			 return "shorten link is: " + id;			
		}
		else return "shorten link is: " + id;
		
	}
}
