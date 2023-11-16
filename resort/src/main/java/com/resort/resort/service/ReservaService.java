package com.resort.resort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.resort.model.Reserva;
import com.resort.resort.repository.ReservaRepository;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listarTodasAsReservas() {
        return reservaRepository.findAll();
    }

    public Reserva buscarReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva criarReserva(Reserva reserva) {
        // Implemente a lógica para criar uma reserva, como validações e salvamento no repositório
        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva(Long id, Reserva reserva) {
        return null;
    }

    public void excluirReserva(Long id) {
    }
}

