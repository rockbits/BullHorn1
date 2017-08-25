package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String listMessages(Model model){
        model.addAttribute("messages", messageRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String messageForm(Model model){
        model.addAttribute("message", new Bull());
        return "messageform";



    }

    @PostMapping("/process")
    public String processForm(@Valid Bull bull, BindingResult result){
        if(result.hasErrors()){
            return "Show";
        }
        messageRepository.save(bull);
        return "redirect:/";
    }
}
