package com.WAEC2GRUPO4.ExamenT2.repository;
import com.WAEC2GRUPO4.ExamenT2.model.bd.pk.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET nombres=:nombres, apellidos=:apellidos, " +
            "activo=:activo WHERE idusuario=:idusuario",
            nativeQuery = true)
    void actualizarUsuario(@Param("nombres")String nombres,
                           @Param("apellidos")String apellidos,
                           @Param("activo")boolean activo,
                           @Param("idusuario")int idusuario);
}