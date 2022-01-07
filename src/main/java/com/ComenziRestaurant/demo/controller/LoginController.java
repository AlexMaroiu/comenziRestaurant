package com.ComenziRestaurant.demo.controller;

import com.ComenziRestaurant.demo.entity.Authorities;
import com.ComenziRestaurant.demo.entity.User;
import com.ComenziRestaurant.demo.entity.UtilizatorNou;
import com.ComenziRestaurant.demo.service.AuthotitiesService;
import com.ComenziRestaurant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @Autowired
    AuthotitiesService authotitiesService;

    @GetMapping("/logare")
    public ModelAndView logare(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logare");

        return mav;
    }

    @GetMapping("/inregistrare")
    public ModelAndView inregistrare(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");

        model.addAttribute("utilizatorNou", new UtilizatorNou());
        return mav;
    }

    @PostMapping("/submitInregistrare")
    public ModelAndView submitInregistrare(@ModelAttribute UtilizatorNou utilizatorNou){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/inregistrare");

        if (utilizatorNou.getParola().equals(utilizatorNou.getCfparola())){
            User user = new User();
            user.setUsername(utilizatorNou.getUsername());
            user.setPassword(passwordEncoder.encode(utilizatorNou.getCfparola()));
            user.setEnabled(true);
            userService.saveUser(user);
            Authorities authorities = new Authorities();
            authorities.setUsername(utilizatorNou.getUsername());
            authorities.setAuthority("ROLE_USER");
            authotitiesService.saveAuthorities(authorities);
            mav.setViewName("redirect:/logare");
        }

        return mav;
    }

}
