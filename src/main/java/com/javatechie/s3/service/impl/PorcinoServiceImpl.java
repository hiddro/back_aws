package com.javatechie.s3.service.impl;

import com.javatechie.s3.entity.Porcino;
import com.javatechie.s3.repository.PorcinoRepository;
import com.javatechie.s3.service.IPorcinoService;
import com.javatechie.s3.service.StorageService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class PorcinoServiceImpl implements IPorcinoService {

    @Autowired
    private PorcinoRepository porcinoRepository;

    @Autowired
    private StorageService storageService;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Override
    public Porcino createPorcino(MultipartFile file, Porcino porcino) {

        String url = storageService.uploadFile(file);
        final String sUrl = "https://" + bucketName + ".s3.amazonaws.com/" + url;
        porcino.setUrl(sUrl);
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
