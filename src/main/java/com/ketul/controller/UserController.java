package com.ketul.controller;

import com.ketul.dto.UserDto;
import com.ketul.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "form";
    }
}
