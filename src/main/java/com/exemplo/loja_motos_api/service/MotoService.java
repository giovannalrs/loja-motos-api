package com.exemplo.loja_motos_api.service;

import com.exemplo.loja_motos_api.model.Moto;
import com.exemplo.loja_motos_api.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> listarMotos() {
        return motoRepository.findAll();
    }

    public Optional<Moto> buscarMotoPorId(Long id) {
        return motoRepository.findById(id);
    }

    public Moto salvarMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deletarMoto(Long id) {
        motoRepository.deleteById(id);
    }
}
