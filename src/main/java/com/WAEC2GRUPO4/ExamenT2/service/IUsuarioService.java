package com.WAEC2GRUPO4.ExamenT2.service;

import com.WAEC2GRUPO4.ExamenT2.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    void cambiarContraseña(String nombreusuario,String password);

}
