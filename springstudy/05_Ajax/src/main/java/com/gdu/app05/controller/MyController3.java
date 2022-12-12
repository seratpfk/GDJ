package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.MovieService;

@Controller
public class MyController3 {

	
	// field
	@Autowired  // Container(root-context.xml)에 저장된 bean을 가져오시오.
	private MovieService movieService;
	

	@GetMapping("/movie")
	public String movie() {
		return "movie";
	}
	
	// 영화진흥위원회 API 사용하기
	
	@ResponseBody
	@GetMapping(value="/movie/boxOfficeList"
			  , produces=MediaType.APPLICATION_JSON_VALUE)
	public String boxOfficeList(@RequestParam String targetDt) {
		return movieService.getBoxOffice(targetDt);
	}
	
}