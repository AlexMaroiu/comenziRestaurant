package com.ComenziRestaurant.demo.controller;


import com.ComenziRestaurant.demo.service.MancareSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @Autowired
    MancareSercive mancareSercive;

    @GetMapping("/admin")
    public ModelAndView admin(Model model){
        model.addAttribute("meniu", mancareSercive.getMancare());
        return new ModelAndView("admin");
    }
}
