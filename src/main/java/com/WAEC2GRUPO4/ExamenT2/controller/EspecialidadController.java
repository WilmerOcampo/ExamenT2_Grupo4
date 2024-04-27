package com.WAEC2GRUPO4.ExamenT2.controller;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Especialidad;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Medico;
import com.WAEC2GRUPO4.ExamenT2.model.dto.request.EspecialidadRequest;
import com.WAEC2GRUPO4.ExamenT2.model.dto.response.EspecialidadResponse;
import com.WAEC2GRUPO4.ExamenT2.service.IEspecialidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/especialidad")
public class EspecialidadController {

    private IEspecialidadService iEspecialidadService;
    @GetMapping("/lista")
    public String especialidades(Model model){
        List<Especialidad> especialidades = iEspecialidadService.findAll();
        model.addAttribute("especialidades",especialidades);
        return "backoffice/especialidad/especialidades";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Especialidad> listEspecialidades(){
        return iEspecialidadService.findAll();
    }

    @PostMapping("/register")
    @ResponseBody
    public EspecialidadResponse registerEspecialidad(@RequestBody EspecialidadRequest especialidadRequest){
        String message = "Especialidad registrado correctamente";
        boolean response = true;
        try{
            Especialidad especialidad = new Especialidad();
            if(especialidadRequest.getIdespecialidad() > 0){
                especialidad.setIdespecialidad(especialidadRequest.getIdespecialidad());
            }
            especialidad.setTitulo(especialidadRequest.getTitulo());
            especialidad.setFuncion(especialidadRequest.getFuncion());
            especialidad.setFechagraduacion(especialidadRequest.getFechagraduacion());
            Medico medico = new Medico();
            medico.setIdmedico(especialidadRequest.getIdmedico());
            especialidad.setMedico(medico);
            iEspecialidadService.save(especialidad);
        }catch (Exception ex){
            message = "Especialidad no registrado, error en la BD.";
            response = false;
        }
        return EspecialidadResponse.builder().mensaje(message).respuesta(response).build();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public EspecialidadResponse eliminarEspecialidad(@PathVariable Integer id) {
        String message = "Especialidad eliminada correctamente";
        boolean response = true;
        try {
            iEspecialidadService.eliminarPorId(id);
        } catch (Exception ex) {
            message = "Error al eliminar la especialidad";
            response = false;
        }
        return EspecialidadResponse.builder().mensaje(message).respuesta(response).build();
    }
}