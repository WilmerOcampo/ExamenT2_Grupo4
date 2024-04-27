package com.WAEC2GRUPO4.ExamenT2.repository;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);

}