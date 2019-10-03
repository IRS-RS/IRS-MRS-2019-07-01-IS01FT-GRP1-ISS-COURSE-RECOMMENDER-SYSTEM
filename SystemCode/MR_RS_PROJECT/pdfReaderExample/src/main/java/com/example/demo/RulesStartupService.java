package com.example.demo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RulesStartupService {
	@Autowired
	Service service;
	@PostConstruct
	public void init() {
		//loading all rules into Kie Session
		this.service.initializeRules();
		System.out.println("KIE Base is initialized");
	}
}
