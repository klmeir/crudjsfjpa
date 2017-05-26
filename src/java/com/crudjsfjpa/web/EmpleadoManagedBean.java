/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.web;

import com.crudjsfjpa.modelo.Empleado;
import com.crudjsfjpa.web.ejb.EmpleadoEjbService;
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
@Named(value = "empleadoManagedBean")
@ViewScoped
public class EmpleadoManagedBean implements Serializable {

    private Empleado empleado = new Empleado();
    private List<Empleado> empleados = new ArrayList<>();
    @EJB(name = "empleadoEjb")
    private EmpleadoEjbService empleadoEjbService;
    private Empleado selectedEmp = new Empleado();

    public Empleado getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(Empleado selectedEmp) {
        this.selectedEmp = selectedEmp;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public EmpleadoEjbService getEmpleadoEjbService() {
        return empleadoEjbService;
    }

    public void setEmpleadoEjbService(EmpleadoEjbService empleadoEjbService) {
        this.empleadoEjbService = empleadoEjbService;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void rowselect(SelectEvent e) {
        empleado = selectedEmp;
    }
    
    public String formatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    /**
     * Creates a new instance of EmpleadoManagedBean
     */
    public EmpleadoManagedBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        empleados = empleadoEjbService.listar();
    }

    public void saveEmpleado() {
        FacesContext fc = FacesContext.getCurrentInstance();
        empleadoEjbService.save(empleado);
        empleados = empleadoEjbService.listar();
        empleado = new Empleado();

        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Empleado Registrado"));

    }
}
