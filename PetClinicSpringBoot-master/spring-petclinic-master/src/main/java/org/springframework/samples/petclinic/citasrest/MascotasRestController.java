/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citasrest;

import org.springframework.samples.petclinic.citas.MascotasRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author donaldoherr
 */
@RestController
public class MascotasRestController {
    
    private final MascotasRepository mascotas;
    
    public MascotasRestController(MascotasRepository mascotas){
           this.mascotas = mascotas;
    }
    
}
