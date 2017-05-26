/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.web.ejb;

import com.crudjsfjpa.dao.impl.EmpleadoDaoImpl;
import com.crudjsfjpa.modelo.Empleado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 */
@Stateless(mappedName = "empleadoEjb")
public class EmpleadoEjbService {

    @PersistenceContext(unitName = "crudjsfjpaPU")
    private EntityManager entityManager;
    private EmpleadoDaoImpl<Empleado> empleadoDao;

    @PostConstruct
    public void init() {
        empleadoDao = new EmpleadoDaoImpl<>();
        empleadoDao.setEntityManager(entityManager);

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Empleado e) {
        empleadoDao.save(e);
    }

    public List<Empleado> listar() {
        return empleadoDao.list();
    }
}
