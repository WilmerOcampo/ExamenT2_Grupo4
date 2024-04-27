package com.WAEC2GRUPO4.ExamenT2.controller;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Usuario;
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
    @PostMapping("/registro")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        iUsuarioService.guardarUsuario(usuario);
        return "backoffice/auth/login";
    }
    @GetMapping("/cambiar-password")
    public String cambiarContraseña(){
        return "backoffice/seguridad/frmcambiarcontraseña";
    }

    @PostMapping("/cambiar")
    public String cambiarContraseñaPost(@RequestParam("nomusuario") String nombreusuario, @RequestParam("password") String contraseña, Model model){
        iUsuarioService.cambiarContraseña(nombreusuario,contraseña);
        model.addAttribute("mensaje","Se cambio satisfactoriamente la contraseña");
        return "backoffice/seguridad/frmcambiarcontraseña";
    }
}

