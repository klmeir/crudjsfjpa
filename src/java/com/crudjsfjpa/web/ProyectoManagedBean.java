/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.web;

import com.crudjsfjpa.modelo.Proyecto;
import com.crudjsfjpa.web.ejb.ProyectoEjbService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 */
@Named(value = "proyectoManagedBean")
@ViewScoped
public class ProyectoManagedBean implements Serializable {

    private Proyecto proyecto = new Proyecto();
    private List<Proyecto> proyectos = new ArrayList<>();
    @EJB(name = "proyectoEjb")
    private ProyectoEjbService proyectoEjbService;
    private Proyecto selectedPro = new Proyecto();

    public Proyecto getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(Proyecto selectedPro) {
        this.selectedPro = selectedPro;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ProyectoEjbService getProyectoEjbService() {
        return proyectoEjbService;
    }

    public void setProyectoEjbService(ProyectoEjbService proyectoEjbService) {
        this.proyectoEjbService = proyectoEjbService;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void rowselect(SelectEvent e) {
        proyecto = selectedPro;
    }

    public String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    /**
     * Creates a new instance of ProyectoManagedBean
     */
    public ProyectoManagedBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        proyectos = proyectoEjbService.listar();
    }

    public void saveProyecto() {
        FacesContext fc = FacesContext.getCurrentInstance();
        proyectoEjbService.save(proyecto);
        proyectos = proyectoEjbService.listar();
        proyecto = new Proyecto();

        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Proyecto Registrado"));

    }

}
