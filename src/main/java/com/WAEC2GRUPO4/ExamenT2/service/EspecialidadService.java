package com.WAEC2GRUPO4.ExamenT2.service;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Especialidad;
import com.WAEC2GRUPO4.ExamenT2.repository.EspecialidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecialidadService implements  IEspecialidadService{

    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Override
    public void save(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public void eliminarPorId(Integer id) {
        especialidadRepository.deleteById(id);
    }
}
