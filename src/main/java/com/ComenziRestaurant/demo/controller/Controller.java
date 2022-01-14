package com.ComenziRestaurant.demo.controller;

import com.ComenziRestaurant.demo.entity.*;
import com.ComenziRestaurant.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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
    public ModelAndView homepage(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        model.addAttribute("oferte", ofertaService.gasesteOfertaData(LocalDate.now()));
        model.addAttribute("comanda", new Comanda());
        return mav;
    }

    @GetMapping("/meniu")
    public ModelAndView meniu(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("meniu");

        List<Mancare> meniu = mancareSercive.getMancare();
        model.addAttribute("meniu", meniu);

        Mancare mancare = new Mancare();
        model.addAttribute("mancar", mancare);
        model.addAttribute("comanda", new Comanda());

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
    public ModelAndView submitComanda(HttpServletRequest request, @ModelAttribute Comanda comanda,
                                      RedirectAttributes redirectAttributes) {

        if(ofertaService.esteInOferta(comanda.getId_mancare())){
            comanda.setPret(comanda.getId_mancare().getPret()*ofertaService.
                    gasesteOferta(comanda.getId_mancare()).getReducere()/100*
                    comanda.getPortii());
        }
        else {
            comanda.setPret(comanda.getId_mancare().getPret()* comanda.getPortii());
        }
        comanda.setUsername(request.getUserPrincipal().getName());
        comandaService.saveComanda(comanda);

        String referer = request.getHeader("Referer");
        //referer = referer.replaceAll("\\?.*", "");
        redirectAttributes.addFlashAttribute("reusit", true);
        return new ModelAndView("redirect:"+ referer);
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

    @GetMapping("/cosDeCumparaturi")
    public ModelAndView cosDeCumparaturi(Model model, HttpServletRequest request){
        var cos = comandaService.gasesteGrupat(request.getUserPrincipal().getName());
        model.addAttribute("comenzi", cos);
        double total = 0;
        for( var q : cos){
            total += q.getPret();
        }

        model.addAttribute("total", total);
        model.addAttribute("istoric", new Istoric());
        return new ModelAndView("cosDeCumparaturi");
    }

    @PostMapping("/submitCos")
    public ModelAndView submitCos(HttpServletRequest request, @ModelAttribute Istoric istoric){
        String username = request.getUserPrincipal().getName();
        User user = userService.getUserByUsername(username);
        istoric.setUsername(user);
        istoric.setData_comanda(LocalDate.now());
        istoricService.save(istoric);
        comandaService.golireCos(username);

        return new ModelAndView("redirect:/");
    }

}
