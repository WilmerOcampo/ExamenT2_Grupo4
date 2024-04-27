package com.WAEC2GRUPO4.ExamenT2.repository;
import com.WAEC2GRUPO4.ExamenT2.model.bd.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
