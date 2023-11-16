package com.resort.resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.resort.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Você pode adicionar métodos personalizados de consulta, se necessário
}
