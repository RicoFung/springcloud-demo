package com.eureka.consumer.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/test")
public class TestAction extends BaseController<Object>
{
	@Autowired
	LoadBalancerClient	loadBalancerClient;
	@Autowired
	RestTemplate		restTemplate;

	@RequestMapping("/dc")
	public void dc()
	{
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/category/query2";
		System.out.println(url);
		System.out.println(restTemplate.getForObject(url, String.class));
		printJson(restTemplate.getForObject(url, String.class));
	}
}