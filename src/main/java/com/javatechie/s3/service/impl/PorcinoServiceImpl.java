package com.javatechie.s3.service.impl;

import com.javatechie.s3.entity.Porcino;
import com.javatechie.s3.repository.PorcinoRepository;
import com.javatechie.s3.service.IPorcinoService;
import com.javatechie.s3.service.StorageService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PorcinoServiceImpl implements IPorcinoService {

    @Autowired
    private PorcinoRepository porcinoRepository;

    @Autowired
    private StorageService storageService;

    @Override
    public Porcino createPorcino(MultipartFile file, Porcino porcino) {
        String url = storageService.uploadFile(file);
        porcino.setUrl(url);
        return porcinoRepository.save(porcino);
    }

    @Override
    @SneakyThrows
    public Porcino findPorcinoById(int id) {
        Porcino porcino = porcinoRepository.findById(id).orElseThrow(() -> new Exception("Porcino no encontrado"));
        return porcino;
    }

    @Override
    public List<Porcino> findAllPorcino() {
        return porcinoRepository.findAll();
    }
}
