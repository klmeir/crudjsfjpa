/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.dao.impl;

import com.crudjsfjpa.dao.EmpleadoDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 * @param <Empleado>
 */
public class EmpleadoDaoImpl<Empleado> implements EmpleadoDao<Empleado> {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Empleado e) {
        this.getEntityManager().persist(e);
    }

    @Override
    public void update(Empleado e) {
        this.getEntityManager().merge(e);
    }

    @Override
    public void delete(Empleado e) {
        this.getEntityManager().remove(e);
    }

    @Override
    public List<Empleado> list() {
        Query query = this.getEntityManager().createQuery("SELECT e "
                + "FROM Empleado E ORDER BY e.id");

        return query.getResultList();
    }

}
