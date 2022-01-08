package com.ComenziRestaurant.demo.controller;

import com.ComenziRestaurant.demo.entity.*;
import com.ComenziRestaurant.demo.service.*;
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
    @Autowired
    OfertaService ofertaService;
    @Autowired
    IstoricService istoricService;
    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView homepage(Model model,
                                 @RequestParam(name = "reusit", required = false) boolean reusit){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        model.addAttribute("oferte", ofertaService.getOferte());
        model.addAttribute("comanda", new Comanda());
        model.addAttribute("reusit", reusit);
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

        if(ofertaService.esteInOferta(comanda.getId_mancare())){
            comanda.setPret(comanda.getId_mancare().getPret()*ofertaService.
                    gasesteOferta(comanda.getId_mancare()).getReducere()/100*
                    comanda.getPortii());
        }
        else {
            comanda.setPret(comanda.getId_mancare().getPret()* comanda.getPortii());
        }
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

    @GetMapping("/cont")
    public ModelAndView cont(Model model, HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        User user = userService.getUserByUsername(username);
        model.addAttribute("istoric", istoricService.getIstoricByUser(user));

        return new ModelAndView("cont");
    }

    @GetMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("test");
    }
}
