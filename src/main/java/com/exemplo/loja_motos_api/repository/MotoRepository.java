package com.exemplo.loja_motos_api.repository;

import com.exemplo.loja_motos_api.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}