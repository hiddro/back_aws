package com.javatechie.s3.controller;

import com.google.gson.Gson;
import com.javatechie.s3.entity.Porcino;
import com.javatechie.s3.repository.PorcinoRepository;
import com.javatechie.s3.service.IPorcinoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/porcino")
public class PorcinoController {

    @Autowired
    private IPorcinoService porcinoService;

    @PostMapping
    public Porcino savePorcino(@RequestParam(value = "file") MultipartFile file,
                               @RequestParam("name") String name,
                               @RequestParam("genero") String genero,
                               @RequestParam("raza") String raza) {

//        Gson gson = new Gson();
//        Porcino porky = gson.fromJson(porcino, Porcino.class);
        Porcino porcino = new Porcino();
        porcino.setNombre(name);
        porcino.setGenero(genero);
        porcino.setRaza(raza);
        porcino.setFechaCompra(new Date());

        return porcinoService.createPorcino(file, porcino);
    }

    @GetMapping
    public List<Porcino> findPorcinos() {
        return porcinoService.findAllPorcino();
    }

    @GetMapping("/{id}")
    public Porcino findPorcinoById(@PathVariable int id) {
        return porcinoService.findPorcinoById(id);
    }
}
