package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.model.TouristData;

import reactor.core.publisher.Mono;

@Controller
public class ReactiveWeb {
	
	
	private WebClient webclient;
	
	public ReactiveWeb(WebClient webclient) {
		this.webclient=webclient;
	}
	
	
	@GetMapping("/")
	public String disp(Model model) {
		List<TouristData> list=webclient.get()
		.uri("/Tourist_List")
		.retrieve()
		.bodyToFlux(TouristData.class)
		.collectList()
		.block();
		model.addAttribute("message",list);
		
		return "index";
	}
	
    @PostMapping("/add")
    public String disp1(@ModelAttribute TouristData data) {
    	
    	webclient.post()
    	.uri("/Tourist_Reg")
    	.bodyValue(data)
    	.retrieve()
    	.bodyToMono(String.class)
    	.block();
    	return "redirect:/";
    }
    
    @PostMapping("/update-Budget")
    public String disp2(@RequestParam Integer id,@RequestParam Double budget) {
    	
   	webclient.patch()
    	.uri(uriBuilder -> uriBuilder.path("/update_Budget")
    			.queryParam("id",id).queryParam("cost", budget).build())
    	.retrieve()
    	.bodyToMono(String.class)
    	.block();
    	
    	return "redirect:/";
    }
	
    @PostMapping("/delete/{id}")
    public String disp3(@PathVariable Integer id) {
   	webclient.delete()
    	.uri("/delete_Tourist/{id}",id)
    	.retrieve()
    	.onStatus(status -> status.value() == 410,
            response -> Mono.empty())
    	.bodyToMono(String.class)
    .block();
    	
    	return "redirect:/";
    }

}
