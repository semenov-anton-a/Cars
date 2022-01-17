package com.cars.Cars;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController 
{
    @GetMapping("/addclient")
    public String Home()
    {
        return "addclient"; 
    }

    @PostMapping("/addclient")
    public String addClient( 
        @RequestParam String firstname,
        @RequestParam String surname
    ){
        
        System.out.println( firstname + " " + surname );
        
        return "redirect:/addclient";
    }

}