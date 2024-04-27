package com.WAEC2GRUPO4.ExamenT2.service;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Especialidad;

import java.util.List;

public interface IEspecialidadService {
    List<Especialidad> findAll();

    void save(Especialidad especialidad);

    void eliminarPorId(Integer id);

}
