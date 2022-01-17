package com.cars.Cars;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController 
{
    @GetMapping("/addcar")
    public String Home()
    {
        return "addcar"; 
    }

    @PostMapping("/addcar")
    public String addNewCar( 
        @RequestParam(value="car[]") String[] car
    ){
        System.out.println( Arrays.toString(car) );
        return "redirect:/addcar";
    }

}