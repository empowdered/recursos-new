package com.recursos.gestion.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/demo")
public class DemoController {

    public DemoController(){

    }


    @GetMapping(value="/getword")
    public String getDemo(){
        String testWord = "";
        try{
            testWord = "Mensaje...funciona!!!";
        }catch(Exception ex1){

        }
        return testWord;
    }
}
