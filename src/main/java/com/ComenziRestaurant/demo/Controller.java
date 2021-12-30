package com.ComenziRestaurant.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MancareSercive mancareSercive;
    @Autowired
    ComandaService comandaService;

    @GetMapping
    public ModelAndView homepage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");



        return mav;
    }

    @GetMapping("/meniu")
    public ModelAndView meniu(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("meniu");


        List<Mancare> meniu = mancareSercive.getMancare();
        model.addAttribute("meniu", meniu);

        return mav;
    }

    @GetMapping("/comanda")
    public ModelAndView comanda(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("comanda");

        List<Mancare> meniu = mancareSercive.getMancare();
        model.addAttribute("meniu", meniu);

        Comanda comanda = new Comanda();
        model.addAttribute("comanda", comanda);

        return mav;
    }

    @PostMapping("/submitComanda")
    public ModelAndView submitComanda(@ModelAttribute Comanda comanda){
        ModelAndView mav = new ModelAndView();

        comandaService.saveComanda(comanda);

        mav.setViewName("redirect:/");
        return mav;
    }


}
