package com.yamanit.red.common.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@CrossOrigin
	@GetMapping("/")
	private String hello() {
		return "hello world!!";
	}
}
