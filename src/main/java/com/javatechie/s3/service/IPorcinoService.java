package com.javatechie.s3.service;

import com.javatechie.s3.entity.Porcino;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPorcinoService {
    /*Post*/
    Porcino createPorcino(MultipartFile file, Porcino porcino);

    /*Get*/
    Porcino findPorcinoById(int id);

    List<Porcino> findAllPorcino();

}
