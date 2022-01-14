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

        model.addAttribute("oferte", ofertaService.gasesteOfertaData(LocalDate.now()));
        model.addAttribute("comanda", new Comanda());
        return new ModelAndView("home");
    }

    @GetMapping("/meniu")
    public ModelAndView meniu(Model model){

        model.addAttribute("meniu", mancareSercive.getMancare());
        model.addAttribute("mancar", new Mancare());
        model.addAttribute("comanda", new Comanda());

        return new ModelAndView("meniu");
    }

    @GetMapping("/comanda")
    public ModelAndView comanda(Model model){
        model.addAttribute("meniu", mancareSercive.getMancare());
        model.addAttribute("comanda", new Comanda());

        return new ModelAndView("comanda");
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
            comanda.setPret(comanda.getId_mancare().getPret() * comanda.getPortii());
        }
        comanda.setUsername(request.getUserPrincipal().getName());
        comandaService.saveComanda(comanda);

        redirectAttributes.addFlashAttribute("reusit", true);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:"+ referer);
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
