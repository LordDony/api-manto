/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citasrest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.samples.petclinic.appointment.Appointment;
import org.springframework.samples.petclinic.appointment.AppointmentRepository;
import org.springframework.samples.petclinic.appointment.SpecialtieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.samples.petclinic.appointment.AppointmentRepository;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author donaldoherr
 * 
 */

@RestController
public class RestCitasController {
    
    private final AppointmentRepository appointmentRepository;
    private final OwnerRepository owners;

    public RestCitasController(AppointmentRepository appointmentRepository, OwnerRepository owners) {
        this.appointmentRepository = appointmentRepository;
        this.owners = owners;
    }
    
    //obtener todas las citas
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas")
    public Collection<Appointment> getCitas() {
        Collection<Appointment> citas = this.appointmentRepository.getAppointments();
        return citas;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas/{citaID}")
    public Appointment getCita(@PathVariable("citaID") int citaID) {
        Appointment cita = this.appointmentRepository.findById(citaID);
        return cita;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas/{ownerID}/owners")
    public Map getCitasByOwner(@PathVariable("ownerID") int ownerID){
        Collection<DataCita> citas = this.appointmentRepository.getCitasByOwner(ownerID);
        HashMap<String, Collection<DataCita>> map = new HashMap<>();
        for(DataCita cita : citas){
            System.out.println(cita.getBirth_date());
        }
        map.put("citas",citas);
        return map;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas/confirmadas")
    public Collection<Appointment> getCitasConfirmadas(){
        Collection<Appointment> citasConfirmadas = this.appointmentRepository.getAppointmentsByConfirmation(1);
        return citasConfirmadas;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas/no-confirmadas")
    public Collection<Appointment> getCitasNoConfirmadas(){
        Collection<Appointment> citasConfirmadas = this.appointmentRepository.getAppointmentsByConfirmation(0);
        return citasConfirmadas;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/api/citas/especialidad/{especialidad}")
    public Collection<Appointment> getCitasByEspecialidad(@PathVariable("especialidad") int especialidad){
        Collection<Appointment> citasByEspecialidad  = this.appointmentRepository.getAppointments(especialidad);
        return citasByEspecialidad;
    }
    
    
    
    
    
    
    
    
}
