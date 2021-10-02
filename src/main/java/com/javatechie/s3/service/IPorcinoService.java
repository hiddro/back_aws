package com.javatechie.s3.service;

import com.javatechie.s3.entity.Porcino;

import java.util.List;

public interface IPorcinoService {
    /*Post*/
    Porcino createPorcino(Porcino porcino);

    /*Get*/
    Porcino findPorcinoById(int id);

    List<Porcino> findAllPorcino();

}
