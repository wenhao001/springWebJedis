package com.springapp.mvc;

import com.springapp.biz.RedisBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private RedisBiz redisBiz;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}


	@RequestMapping(value = "/redis/add/key/{key}/value/{value}", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> addRedis(@PathVariable(value = "key") String key,
										@PathVariable(value = "value") String value){
		boolean result = redisBiz.add(key, value);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result);
		resultMap.put("message", result ? "success" : "fail");
		return resultMap;
	}

	@RequestMapping(value = "/redis/get/key/{key}", method = RequestMethod.GET)
	public Map<String, Object> getRedis(@PathVariable String key){
		String value = redisBiz.getString(key);
	}


}