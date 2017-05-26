/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.web.ejb;

import com.crudjsfjpa.dao.impl.ProyectoDaoImpl;
import com.crudjsfjpa.modelo.Proyecto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 */
@Stateless(mappedName = "proyectoEjb")
public class ProyectoEjbService {

    @PersistenceContext(unitName = "crudjsfjpaPU")
    private EntityManager entityManager;
    private ProyectoDaoImpl<Proyecto> proyectoDao;

    @PostConstruct
    public void init() {
        proyectoDao = new ProyectoDaoImpl<>();
        proyectoDao.setEntityManager(entityManager);

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Proyecto p) {
        proyectoDao.save(p);
    }

    public List<Proyecto> listar() {
        return proyectoDao.list();
    }
}
