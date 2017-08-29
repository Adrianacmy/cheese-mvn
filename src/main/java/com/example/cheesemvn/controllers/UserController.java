package com.example.cheesemvn.controllers;

import com.example.cheesemvn.models.User;
import com.example.cheesemvn.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String userindex(Model model){
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title","All Users");
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAdd(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title","Add A User");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST )
    public String processAdd(@ModelAttribute @Valid User user,  Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add A User");
            return "user/add";
        }
        UserData.add(user);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeses(Model model){
        model.addAttribute("title", "");
        model.addAttribute("users", UserData.getAll());
        return "user/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeUsers(@RequestParam int[] removeIds){
        for(int removeId : removeIds){
            UserData.remove(removeId);
        }
        return "redirect:";
    }


}
