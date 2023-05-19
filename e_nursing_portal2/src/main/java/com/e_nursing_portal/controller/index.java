package com.e_nursing_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
   @RequestMapping("/index4")
    public String index1(){
        return "index";
    }
}
