package com.mayikt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RefreshScope//Nacos自动刷新功能
public class NacosController {
	@Value("${mayikt.name}")
	private String userName;
	@RequestMapping("/getConfig")
	public String getConfig() {
		return "从阿里巴巴的Nacos分布式配置中心动态读过来的配置:" + userName;
	}
	public static void main(String[] args) {
		//nacos的配置中心地址必须配置在bootstrap.yml配置文件里面
		SpringApplication.run(NacosController.class, args);
	}
}