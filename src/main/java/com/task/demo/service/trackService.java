package com.task.demo.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
@Service
public class trackService {

	public RedirectView trackUrl(String OriginalUrl) throws MalformedURLException {
		
		URL url=new URL(OriginalUrl);
		String query=url.getQuery();
		String link="/track?"+query;
		System.out.println(query);
		System.out.println(OriginalUrl);
		System.out.println(link);
		RedirectView redirectView = new RedirectView();
	       redirectView.setUrl(link);
	 
		return redirectView;
	}
}
