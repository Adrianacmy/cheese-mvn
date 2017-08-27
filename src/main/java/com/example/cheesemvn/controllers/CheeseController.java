package com.example.cheesemvn.controllers;

import com.example.cheesemvn.models.Category;
import com.example.cheesemvn.models.Cheese;
import com.example.cheesemvn.models.CheeseRate;
import com.example.cheesemvn.models.data.CategoryDao;
import com.example.cheesemvn.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String cheese(Model model){
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "I Hate Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("cheeseRates", CheeseRate.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors,
                                       @RequestParam int categoryId,
                                       Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("categories", categoryDao.findAll());
            return "cheese/add";
        }
        Category cat = categoryDao.findOne(categoryId);
        newCheese.setCategory(cat);
        cheeseDao.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeses(Model model){
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeseDao.findAll());
//        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeses(@RequestParam int[] removeIds){
        for(int removeId : removeIds){
            cheeseDao.delete(removeId);
        }
        return "redirect:";
    }

//    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
//    public String displayEditForm(Model model, @PathVariable int id){
//        Cheese cheeseToEdit = cheeseDao.findOne(id);
//        model.addAttribute("cheeseToEdit", cheeseToEdit);
//        model.addAttribute("categories", categoryDao.findAll());
//        model.addAttribute("cheeseRates", CheeseRate.values());
//
//        return "cheese/edit";
//
//    }
//
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    public String processEditForm(@RequestParam int id, @RequestParam String name,
//                                  @RequestParam String description, @RequestParam int categoryId,
//                                  @RequestParam CheeseRate rate){
//        Cheese cheeseToUpdate = cheeseDao.findOne(id);
//        Category category = categoryDao.findOne(categoryId);
//        cheeseToUpdate.setName(name);
//        cheeseToUpdate.setDescription(description);
//        cheeseToUpdate.setCategory(category);
//        cheeseToUpdate.setRate(rate);
//        cheeseDao.save(cheeseToUpdate);
//        return "redirect:";
//    }

    @RequestMapping(value = "category", method=RequestMethod.GET)
    public String category(Model model, @RequestParam int id) {
        // hybernate will populate all the cheeses in the list under id cat

        Category cat = categoryDao.findOne(id);
        List<Cheese> cheeses = cat.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheeses in Category: " + cat.getName());

        return "cheese/index";
    }

}
