/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Collection;
import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;
import org.springframework.samples.petclinic.appointment.Appointment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author donaldoherr
 */
@RestController
public class OwnerRestController {
    
    OwnerRestRepository owners;
    private PasswordEncoder pass;
    public OwnerRestController(OwnerRestRepository owners){
        this.owners =  owners;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/api/owners/login")
    public ArrayList<OwnerRest> getOwners() {
        
        
        String password = "admin";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = "{bcrypt}"+passwordEncoder.encode(password);
        
        System.out.println("Password = "+hashedPassword);
        ArrayList<OwnerRest> owner = this.owners.getByEmailUser("admin@admin.com","{bcrypt}$2a$10$iW6qYvcNvLkVvpHHKipjOesInnL1aJ5qJBn2e7RcGNcAUKpZ745Ku");
        return owner;
        /*ArrayList<OwnerRest> owners = this.owners.All();
        return owners;*/
    }
    
    /*@RequestMapping(method = RequestMethod.GET, path = "/api/owners/{owner}")
    public Appointment getCita(@PathVariable("citaID") int citaID) {
      
    }*/
    
    
    
    
    
}
