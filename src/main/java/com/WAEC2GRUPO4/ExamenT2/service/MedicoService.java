package com.WAEC2GRUPO4.ExamenT2.service;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Medico;
import com.WAEC2GRUPO4.ExamenT2.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService implements IMedicoService {
    private MedicoRepository medicoRepository;
    @Override
    public List<Medico> listaMedicos() {
        return medicoRepository.findAll();
    }
}
