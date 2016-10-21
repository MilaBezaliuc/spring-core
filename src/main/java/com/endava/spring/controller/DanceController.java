package com.endava.spring.controller;

import com.endava.spring.entity.Dance;
import com.endava.spring.entity.Man;
import com.endava.spring.entity.Woman;
import com.endava.spring.service.DanceServiceImlp;
import com.endava.spring.service.ManServiceImpl;
import com.endava.spring.service.WomanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DanceController {

    @Autowired
    private DanceServiceImlp danceService;

    @Autowired
    private ManServiceImpl manService;

    @Autowired
    private WomanServiceImpl womanService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listDances(Model model) {
        model.addAttribute("dances", new Dance());
        model.addAttribute("listOfDances", danceService.listOfDances());
        model.addAttribute("woman", new Woman());
        model.addAttribute("listOfWomen", womanService.getListOfWomen());
        model.addAttribute("man", new Man());
        model.addAttribute("listOfMen", manService.getListOfMen());
        return "party";
    }

    @RequestMapping(value = "/party/add", method = RequestMethod.GET)
    public String listOfWomen(Model model) {
        model.addAttribute("woman", new Woman());
        model.addAttribute("listOfWomen", womanService.getListOfWomen());
        model.addAttribute("man", new Man());
        model.addAttribute("listOfMen", manService.getListOfMen());
        return "party";
    }

    @RequestMapping(value = "/party/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("dance") Dance dance) {
        danceService.addDance(dance);
        return "redirect:/party";
    }
}
