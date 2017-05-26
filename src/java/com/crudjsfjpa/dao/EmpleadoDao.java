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
 * @param <Empleado>
 */
public interface EmpleadoDao<Empleado> {
    void save(Empleado e);
    void update(Empleado e);
    void delete(Empleado e);
    List<Empleado> list();
}
