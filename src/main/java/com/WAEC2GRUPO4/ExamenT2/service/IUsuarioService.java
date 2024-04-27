package com.WAEC2GRUPO4.ExamenT2.service;

import com.WAEC2GRUPO4.ExamenT2.model.bd.pk.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioxId(int id);
    void actualizarUsuario(Usuario usuario);

    void cambiarContraseña(String nombreusuario,String password);

}
