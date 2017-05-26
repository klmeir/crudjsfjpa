/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudjsfjpa.dao;

import java.util.List;

/**
 *
 * @author Carlos Meriño Iriarte <carlos.merino.iriarte@gmail.com>
 * @param <Proyecto>
 */
public interface ProyectoDao<Proyecto> {
    void save(Proyecto e);
    void update(Proyecto e);
    void delete(Proyecto e);
    List<Proyecto> list();
}
