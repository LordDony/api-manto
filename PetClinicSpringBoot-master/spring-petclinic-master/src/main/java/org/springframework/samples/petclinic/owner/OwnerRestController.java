/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.samples.petclinic.appointment.Appointment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author donaldoherr
 */
@RestController
public class OwnerRestController {
    
    OwnerRestRepository owners;
    
    public OwnerRestController(OwnerRestRepository owners){
        this.owners =  owners;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/api/owners/login")
    public ArrayList<OwnerRest> getOwners() {
        ArrayList<OwnerRest> owners = this.owners.All();
        return owners;
    }
    
    /*@RequestMapping(method = RequestMethod.GET, path = "/api/owners/{owner}")
    public Appointment getCita(@PathVariable("citaID") int citaID) {
      
    }*/
    
    
    
    
    
}
