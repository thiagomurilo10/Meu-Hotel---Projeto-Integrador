package com.resort.resort.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resort.resort.model.Reserva;
import com.resort.resort.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Rota para criar uma nova reserva (POST)
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.criarReserva(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    // Rota para obter todas as reservas (GET)
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        List<Reserva> reservas = reservaService.listarTodasAsReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    // Rota para obter uma reserva pelo ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obterReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarReservaPorId(id);
        return ResponseEntity.of(Optional.ofNullable(reserva));
    }

    // Rota para atualizar uma reserva existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaAtualizada = reservaService.atualizarReserva(id, reserva);
        return ResponseEntity.of(Optional.ofNullable(reservaAtualizada));
    }

    // Rota para excluir uma reserva (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirReserva(@PathVariable Long id) {
        reservaService.excluirReserva(id);
        return ResponseEntity.noContent().build();
    }
}

