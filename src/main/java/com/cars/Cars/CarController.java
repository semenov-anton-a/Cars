package com.cars.Cars;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        @RequestParam String carYear,
        @RequestParam String carReg
    ){
        carRepo.save( new Car(vinCode, carBrand, carModel, carYear, carReg) );	
        return "redirect:/addcar";
    }

}