package com.cars.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController 
{
    @Autowired
    private ClientRepository clientRepo;

    @Autowired 
    private CarRepository carRepo;

    @GetMapping("/addclient")
    public String Home( Model model )
    {
        model.addAttribute( "clients", clientRepo.findAll() );
        model.addAttribute( "cars", carRepo.findAll() );
        return "addclient"; 
    }

    /**
     * Get POST 
     * Save user Data
     * @param firstname
     * @param surname
     * @return
     */
    @PostMapping("/addclient")
    public String addClient( 
        @RequestParam String firstname,
        @RequestParam String surname
    ){       
        clientRepo.save( 
            new Client( firstname, surname, new ArrayList<>() )
        );

        return "redirect:/addclient";
    }


    @Transactional
    @PostMapping("/addclient/clicars")
    public String addRelClientCars( 
        @RequestParam Long clientid,
        @RequestParam (value = "carids[]") List<Long> carids
    ){

        // System.out.println(clientid);
        // System.out.println("============");
        // System.out.println(carids);


        carids.forEach( c -> carRepo.addLinks(clientid, c) );



        // Long clientID = (long) Integer.parseInt(clientid);


        // System.out.println( "======================" );
        // // System.out.println( carRepo.getById((long) 2) );
        // System.out.println( 
        //     clientRepo.getById(clientID).getCars().add4(carids) 
        // );
        // System.out.println( "STOP" );
        // System.out.println( "======================" );

        // clientRepo.getOne( clientID ).getCars().add( carRepo.getOne((long) 3 ));

        // carRepo.getById((long) 3 ).getClients().add( clientRepo.getById(clientID) );

        // clientRepo.getOne(clientID).getCars().add( carRepo.getOne( (long) 3 ) );

        // clientRepo.getById(clientID).getCars().add( 3, carRepo.getById( (long) 2 ) );


        // System.out.println( one );



        // System.out.println("CLIENT ID : " + clientid );
        // System.out.println(Arrays.toString(carids));
        return "redirect:/addclient";
    }

}