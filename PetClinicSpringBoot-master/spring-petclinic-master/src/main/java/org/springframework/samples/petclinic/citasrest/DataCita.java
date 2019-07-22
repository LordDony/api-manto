/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citasrest;

import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author donaldoherr
 */
public class DataCita extends BaseEntity{
    
    private Integer citaID;
    private String  fecha;
    private String  hora;
    private Integer confirmacion;
    private String  name;
    private String birth_date;
    

    public Integer getCitaID() {
        return citaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setCitaID(Integer citaID) {
        this.citaID = citaID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Integer confirmacion) {
        this.confirmacion = confirmacion;
    }
    
    
    
}
