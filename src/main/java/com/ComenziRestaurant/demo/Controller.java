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

    @GetMapping("/meniu")
    public ModelAndView meniu(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("meniu");

        return mav;
    }

    @GetMapping("/comanda")
    public ModelAndView comanda(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("comanda");

        return mav;
    }



}
