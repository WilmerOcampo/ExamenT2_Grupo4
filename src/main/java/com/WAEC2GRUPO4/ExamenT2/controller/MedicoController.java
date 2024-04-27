package com.WAEC2GRUPO4.ExamenT2.controller;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Medico;
import com.WAEC2GRUPO4.ExamenT2.service.IMedicoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/medico")
public class MedicoController {

    private IMedicoService iMedicoService;

    @GetMapping("/list")
    @ResponseBody
    public List<Medico> listaMedicos(){
        return iMedicoService.listaMedicos();
    }

}
