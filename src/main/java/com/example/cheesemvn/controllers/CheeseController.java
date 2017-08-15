package com.example.cheesemvn.controllers;

import com.example.cheesemvn.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.regex.Pattern.matches;


@Controller
@RequestMapping("cheese")
public class CheeseController {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String cheese(Model model){
        model.addAttribute("cheeses", cheeses);

        model.addAttribute("title", "I Hate Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription, Model model){
        String pattern = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
        if (cheeseName != null && matches(pattern, cheeseName)){
            Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
            cheeses.add(newCheese);
            return "redirect:";
        }else{
            cheeseName = "";
            String addCheeseDescription = cheeseDescription;
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseDescription", addCheeseDescription);
            model.addAttribute("cheeseName", cheeseName);

            return "cheese/add";
        }

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeses(Model model){
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeses(@RequestParam ArrayList<String> cheeseRemoving){
        for(String acheese : cheeseRemoving){
            cheeses.remove(acheese);
        }
        return "redirect:";
    }
}
