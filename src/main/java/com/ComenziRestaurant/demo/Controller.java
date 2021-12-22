package com.ComenziRestaurant.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {


    @GetMapping
    public ModelAndView homepage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        return mav;
    }

}
