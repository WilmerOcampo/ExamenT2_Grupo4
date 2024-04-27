package com.WAEC2GRUPO4.ExamenT2.service;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Rol;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Usuario;
import com.WAEC2GRUPO4.ExamenT2.repository.RolRepository;
import com.WAEC2GRUPO4.ExamenT2.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 *
 */
@AllArgsConstructor
@Service
public class UsuarioService  implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findUserByNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void cambiarContraseña(String nombreusuario, String password) {
        Usuario usuario = findUserByNomUsuario(nombreusuario);
        usuario.setPassword(bCryptPasswordEncoder.encode(password));
        usuarioRepository.save(usuario);
    }
}
