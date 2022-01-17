package com.cars.Cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarsController {

    // Cars List
    private String carsList;
    
    // Clients List
    private String ownersList;
    
    @GetMapping("/")
    public String Home( Model model )
    {
        model.addAttribute("ownersList", ownersList);
        model.addAttribute("carsList", carsList);
        return "index";
    }
    
    /**
     * Show owners by car ID
     * @param car
     * @return
     */
    @PostMapping("/fowners")
    public String searchOwnerByCarID(@RequestParam String carID)
    {
        this.carsList = ""; // RESET
        this.ownersList = carID;
        return "redirect:/";
    }

    /**
     * Show Cars by owners ID 
     * @param ownerID
     * @return
     */
    @PostMapping("/fcars")
    public String searchCarsByOwnerID(@RequestParam String ownerID)
    {
        this.ownersList = ""; // RESET
        this.carsList = ownerID;
        return "redirect:/";
    } 


}
