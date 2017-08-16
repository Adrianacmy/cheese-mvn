package com.example.cheesemvn.controllers;

import com.example.cheesemvn.models.Cheese;
import com.example.cheesemvn.models.CheeseData;
import com.example.cheesemvn.models.CheeseRate;
import com.example.cheesemvn.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("cheese")
public class CheeseController {
//    static ArrayList<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String cheese(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "I Hate Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("cheeseRates", CheeseRate.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeses(Model model){
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeses(@RequestParam int[] removeIds){
        for(int removeId : removeIds){
            CheeseData.remove(removeId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese cheeseToEdit = CheeseData.getById(cheeseId);
        model.addAttribute("cheeseToEdit", cheeseToEdit);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("cheeseRates", CheeseRate.values());

        return "cheese/edit";

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@RequestParam int cheeseId, @RequestParam String name,
                                  @RequestParam String description, @RequestParam CheeseType type,
                                  @RequestParam CheeseRate rate){
        Cheese cheeseToUpdate = CheeseData.getById(cheeseId);
        cheeseToUpdate.setName(name);
        cheeseToUpdate.setDescription(description);
        cheeseToUpdate.setType(type);
        cheeseToUpdate.setRate(rate);
//        CheeseData.update(cheeseId, name, description);
        return "redirect:";
    }
}
