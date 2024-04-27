package com.WAEC2GRUPO4.ExamenT2.controller;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Especialidad;
import com.WAEC2GRUPO4.ExamenT2.service.IEspecialidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/especialidad")
public class EspecialidadController {

    private IEspecialidadService iEspecialidadService;
    @GetMapping("/lista")
    public String especialidades(Model model){
        List<Especialidad> especialidades = iEspecialidadService.listaEspecialidades();
        model.addAttribute("especialidades",especialidades);
        return "backoffice/especialidad/frmespecialidad";
    }

}
