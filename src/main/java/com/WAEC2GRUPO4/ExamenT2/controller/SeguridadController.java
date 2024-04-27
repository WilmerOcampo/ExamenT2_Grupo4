package com.WAEC2GRUPO4.ExamenT2.controller;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Usuario;
import com.WAEC2GRUPO4.ExamenT2.service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private IUsuarioService iUsuarioService;

    @GetMapping("/registro")
    public String registrousuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "backoffice/seguridad/register";
    }

    @PostMapping("/registro")
    public String guardarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "backoffice/seguridad/register";
        }
        iUsuarioService.guardarUsuario(usuario);
        return "backoffice/auth/login";
    }

    @GetMapping("/cambiar-password")
    public String cambiarContraseña() {
        return "backoffice/seguridad/frmcambiarcontraseña";
    }

    @PostMapping("/cambiar")
    public String cambiarContraseñaPost(@RequestParam("nomusuario") String nombreusuario, @RequestParam("password1") String contrasenia1,@RequestParam("password2") String contrasenia2, Model model) {
        if (!contrasenia1.equals(contrasenia2)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "backoffice/seguridad/frmcambiarcontraseña";
        }else{
            iUsuarioService.cambiarContraseña(nombreusuario, contrasenia1);
            model.addAttribute("mensaje", "Se cambio satisfactoriamente la contraseña");
            return "backoffice/seguridad/frmcambiarcontraseña";
        }
    }
}
