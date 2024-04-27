package com.WAEC2GRUPO4.ExamenT2.controller;
import com.WAEC2GRUPO4.ExamenT2.model.bd.pk.Usuario;
import com.WAEC2GRUPO4.ExamenT2.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private IUsuarioService iUsuarioService;
    @GetMapping("/registro")
    public String registrousuario(){
        return "backoffice/seguridad/register";
    }

    @GetMapping("/cambiar-password")
    public String cambiarContraseña(){
        return "backoffice/seguridad/frmcambiarcontraseña";
    }

    @PostMapping("/cambiar")
    public String cambiarContraseñaPost(@RequestParam("nomusuario") String nombreusuario, @RequestParam("password") String contraseña, Model model){
        iUsuarioService.cambiarContraseña(nombreusuario,contraseña);
        model.addAttribute("mensaje","Se cambio satisfactoriamente la contraseña");
        return "redirect:/seguridad/cambiar-password";
    }
}

