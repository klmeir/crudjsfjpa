/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.dao.impl;

import com.crudjsfjpa.dao.ProyectoDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 * @param <Proyecto>
 */
public class ProyectoDaoImpl<Proyecto> implements ProyectoDao<Proyecto> {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Proyecto p) {
        this.getEntityManager().persist(p);
    }

    @Override
    public void update(Proyecto p) {
        this.getEntityManager().merge(p);
    }

    @Override
    public void delete(Proyecto p) {
        this.getEntityManager().remove(p);
    }

    @Override
    public List<Proyecto> list() {
        Query query = this.getEntityManager().createQuery("SELECT p "
                + "FROM Proyecto p ORDER BY p.id");

        return query.getResultList();
    }

}
