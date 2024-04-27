package com.WAEC2GRUPO4.ExamenT2.repository;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer> {


}
