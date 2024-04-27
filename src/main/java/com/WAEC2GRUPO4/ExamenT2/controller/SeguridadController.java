package com.WAEC2GRUPO4.ExamenT2.controller;
import com.WAEC2GRUPO4.ExamenT2.model.bd.pk.Usuario;
import com.WAEC2GRUPO4.ExamenT2.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    @GetMapping("/registro")
    public String registrousuario(){
        return "backoffice/seguridad/register";
    }
}

