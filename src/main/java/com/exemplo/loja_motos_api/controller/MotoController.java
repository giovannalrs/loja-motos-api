package com.exemplo.loja_motos_api.controller;

import com.exemplo.loja_motos_api.model.Moto;
import com.exemplo.loja_motos_api.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public List<Moto> listarMotos() {
        return motoService.listarMotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarMotoPorId(@PathVariable Long id) {
        Optional<Moto> moto = motoService.buscarMotoPorId(id);
        return moto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Moto> criarMoto(@RequestBody Moto moto) {
        Moto novaMoto = motoService.salvarMoto(moto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMoto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMoto(@PathVariable Long id) {
        motoService.deletarMoto(id);
        return ResponseEntity.noContent().build();
    }
}