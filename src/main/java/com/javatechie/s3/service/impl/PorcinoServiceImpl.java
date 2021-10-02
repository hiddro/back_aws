package com.javatechie.s3.service.impl;

import com.javatechie.s3.entity.Porcino;
import com.javatechie.s3.repository.PorcinoRepository;
import com.javatechie.s3.service.IPorcinoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcinoServiceImpl implements IPorcinoService {

    @Autowired
    private PorcinoRepository porcinoRepository;

    @Override
    public Porcino createPorcino(Porcino porcino) {
        return porcinoRepository.save(porcino);
    }

    @Override
    @SneakyThrows
    public Porcino findPorcinoById(int id) {
        Porcino porcino = porcinoRepository.findById(id).orElseThrow(() -> new Exception("User no disponible"));
        return porcino;
    }

    @Override
    public List<Porcino> findAllPorcino() {
        return porcinoRepository.findAll();
    }
}
