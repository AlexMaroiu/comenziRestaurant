package com.ComenziRestaurant.demo.controller;

import com.ComenziRestaurant.demo.entity.*;
import com.ComenziRestaurant.demo.service.AuthotitiesService;
import com.ComenziRestaurant.demo.service.ComandaService;
import com.ComenziRestaurant.demo.service.MancareSercive;
import com.ComenziRestaurant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView meniu(Model model,
                              @RequestParam(name = "reusit", required = false) boolean reusit){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("meniu");

        List<Mancare> meniu = mancareSercive.getMancare();
        model.addAttribute("meniu", meniu);

        Mancare mancare = new Mancare();
        model.addAttribute("mancar", mancare);
        model.addAttribute("comanda", new Comanda());
        model.addAttribute("reusit", reusit);

        return mav;
    }

    @GetMapping("/comanda")
    public ModelAndView comanda(Model model,
                                @RequestParam(value = "reusit", required = false) boolean reusit){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("comanda");

        List<Mancare> meniu = mancareSercive.getMancare();
        model.addAttribute("meniu", meniu);

        Comanda comanda = new Comanda();
        model.addAttribute("comanda", comanda);
        model.addAttribute("reusit", reusit);

        return mav;
    }

    @PostMapping("/submitComanda")
    public ModelAndView submitComanda(HttpServletRequest request, @ModelAttribute Comanda comanda) {
        comandaService.saveComanda(comanda);

        String referer = request.getHeader("Referer");
        referer = referer.replaceAll("\\?.*", "");
        return new ModelAndView("redirect:"+ referer + "?reusit=true");
    }


    @PostMapping("/submitAlege")
    public ModelAndView submitAlege(@ModelAttribute Mancare mancare, Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/portii/"+mancare.getId());

        return mav;
    }


    @GetMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("test");
    }
}
