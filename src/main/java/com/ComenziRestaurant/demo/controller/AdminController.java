package com.ComenziRestaurant.demo.controller;


import com.ComenziRestaurant.demo.entity.Oferta;
import com.ComenziRestaurant.demo.service.MancareSercive;
import com.ComenziRestaurant.demo.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class AdminController {
    @Autowired
    MancareSercive mancareSercive;

    @Autowired
    OfertaService ofertaService;

    @GetMapping("/admin")
    public ModelAndView admin(Model model){
        model.addAttribute("meniu", mancareSercive.getMancare());
        model.addAttribute("oferta", new Oferta());
        return new ModelAndView("admin");
    }

    @PostMapping("/submitAdmin")
    public ModelAndView submitAdmin(@ModelAttribute(name = "oferta") Oferta oferta, RedirectAttributes redirectAttributes){
        ofertaService.save(oferta);
        redirectAttributes.addFlashAttribute("mesaj", "Oferta a fost adauata in baza de date");
        return new ModelAndView("redirect:/admin");
    }
}
