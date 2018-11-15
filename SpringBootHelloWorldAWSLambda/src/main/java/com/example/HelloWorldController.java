package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class HelloWorldController {

	@GetMapping("/hello")
	public String test(@RequestParam("name") String name) {
		return "hello " + name;
	}
}
