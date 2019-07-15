/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;
import org.springframework.samples.petclinic.appointment.Appointment;
import org.springframework.samples.petclinic.appointment.UserHelping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;

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
    public ArrayList<UserHelping> getOwners() {
        String password = "admi";
        String email = "admin@admin.com";
        
        ArrayList<UserHelping> userData = this.owners.getByEmailUser("admin@admin.com");
        String pass = null;
        for(UserHelping user : userData){
            pass = user.getPassword();
        }
        String [] strPass = pass.split("}");
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(strPass[1]);
        System.out.println(pass);
        if(b.matches(password,  strPass[1]) == false){
            System.out.println("no estas logeado");
            return userData;
        }else return userData;
        /*ArrayList<OwnerRest> owners = this.owners.All();
        return owners;*/
    }
    /*@RequestMapping(method = RequestMethod.GET, path = "/api/owners/{owner}")
    public Appointment getCita(@PathVariable("citaID") int citaID) {
      
    }*/
    
    
    
    
    
}
