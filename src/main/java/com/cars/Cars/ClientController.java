package com.cars.Cars;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController 
{
    @Autowired
    private ClientRepository clientRepo;

    @GetMapping("/addclient")
    public String Home()
    {
        return "addclient"; 
    }

    /**
     * Get POST 
     * Save user Data
     * @param firstname
     * @param surname
     * @return
     * 
     * 
     */
    @PostMapping("/addclient")
    public String addClient( 
        @RequestParam String firstname,
        @RequestParam String surname
    ){       
        clientRepo.save( 
            new Client( 
                firstname, 
                surname, 
                new ArrayList<>() 
            )
        );

        return "redirect:/addclient";
    }

}