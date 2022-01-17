package com.cars.Cars;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController 
{
    @Autowired
    private CarRepository carRepo;

    @GetMapping("/addcar")
    public String Home()
    {
        return "addcar"; 
    }

    /**
     * POST 
     * Add new Car Data 
     * @param vinCode
     * @param carBrand
     * @param carModel
     * @param carYear
     * @param carReg
     * @return
     */
    @PostMapping("/addcar")
    public String addNewCar( 
        @RequestParam String vinCode, 
        @RequestParam String carBrand,  
        @RequestParam String carModel,  
        @RequestParam String carReg, 
        @RequestParam String carYear
    )
    {
        carRepo.save( 
            new Car( vinCode, carBrand, carModel, carReg, carYear, new ArrayList<>()  
        ));

        return "redirect:/addcar";
    }

}