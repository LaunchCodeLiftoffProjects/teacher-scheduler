package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.TypeDao;
import com.teacher.teacherscheduler.data.UserDao;
import com.teacher.teacherscheduler.models.Type;
import com.teacher.teacherscheduler.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserDao userDao;
    @Autowired
    private TypeDao typeDao;



    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("user", userDao.findAll());
        model.addAttribute("types", typeDao.findAll());
        model.addAttribute("title", "Register");
        return "user/add";
    }

     @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify, @RequestParam int typeId) {

        List<User> sameName = userDao.findByUsername(user.getUsername());
         model.addAttribute("types", typeDao.findAll());

         if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {
            model.addAttribute("user", user);
            model.addAttribute("users", userDao.findAll());
             Type type = typeDao.findOne(typeId);
             user.setType(type);
            userDao.save(user);
            return "user/index";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("title", "Register");
            if(!user.getPassword().equals(verify)) {
                model.addAttribute("message", "Passwords must match");
                user.setPassword("");
            }

            if(!sameName.isEmpty()) {
                model.addAttribute("message", "Username is taken, please select another one");
            }
            return "user/add";
        }
    }
    //NEW FEATURE: LINKING TYPE WITH USER

    @RequestMapping(value = "login")
    public String loginForm(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, HttpServletResponse response) {
        List<User> u = userDao.findByUsername(user.getUsername());
        if(u.isEmpty()) {
            model.addAttribute("message", "Invalid Username");
            model.addAttribute("title", "Login");
            return "user/login";
        }

        User loggedIn = u.get(0);
        if(loggedIn.getPassword().equals(user.getPassword())) {

            Cookie c = new Cookie("user", user.getUsername());
            c.setPath("/");
            response.addCookie(c);
            model.addAttribute("user", user);
            model.addAttribute("users", userDao.findAll());


            return "user/index";
        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }
        return "redirect:login";
    }

}