/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.controller;

import brewery.src.model.Breweries;
import java.util.Date;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author k00203657
 */
@Controller
@RequestMapping("/breweries")
@SessionAttributes("breweries")
public class BreweriesController {

    @Autowired
    BreweriesService service;

    @RequestMapping("")
    public ModelAndView getBreweries() {
        //int x = Integer.parseInt("abc");
        return new ModelAndView("/allBreweries", "breweriesList", service.getAllBreweries());
    }

    @GetMapping("/add")
    public ModelAndView displayAgentAddForm() {
        return new ModelAndView("/addBrewery", "brewerie", new Breweries());
    }

    @PostMapping("/addBrewery")
    public ModelAndView addAnBrewery(ModelMap model, @Valid @ModelAttribute("brewerie") Breweries brewerie, BindingResult result) {
        Date date = new Date();
        brewerie.setLastMod(date);
        brewerie.setId(1);
        brewerie.setImage("no_image.jpg");
        if (result.hasErrors()) {
           
            return new ModelAndView("/addBrewery");
        }

        service.addAnBreweries(brewerie);
        return new ModelAndView("redirect:/breweries");

    }

    @GetMapping("/delete")
    public ModelAndView deleteAnBrewery(@RequestParam("id") int id) {

        service.deleteAnBrewery(id);

        return new ModelAndView("redirect:/breweries");

    }

    @GetMapping("/edit")
    public ModelAndView editBrewery(@QueryParam("id") int id, ModelAndView model) {

        model.addObject("brewerie", service.getBrewereriesID(id));
        model.setViewName("/editBrewery");
        return model;
        //  return new ModelAndView("/editBrewery", "brewery", service.getBrewereriesID(id));
    }

    @RequestMapping("/updateBrewery")
    public ModelAndView updateBrewery(@Valid @ModelAttribute("brewerie") Breweries brewerie, BindingResult result) {
//        service.updateBrewery(brewerie);
////            return new ModelAndView("/error");
//
//        return new ModelAndView("/allBreweries", "breweriesList", service.getAllBreweries());
        Date date = new Date();
        brewerie.setLastMod(date);
        if (result.hasErrors()) {
   
            return new ModelAndView("/editBrewery");
        }

        service.updateBrewery(brewerie);
        return new ModelAndView("redirect:/breweries");
    }

}
