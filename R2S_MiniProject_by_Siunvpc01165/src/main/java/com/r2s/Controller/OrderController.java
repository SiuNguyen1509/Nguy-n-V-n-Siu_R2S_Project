package com.r2s.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.r2s.Service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	@RequestMapping("/cart/view")
	public String list() {
		return "cart/view";
	}
	@RequestMapping("/order/list")
	public String listinfo(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("order",orderService.findByUsername(username));
		return "order/info";
	}
	
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
}
