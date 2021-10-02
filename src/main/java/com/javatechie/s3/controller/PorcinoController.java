package com.javatechie.s3.controller;

import com.javatechie.s3.entity.Porcino;
import com.javatechie.s3.repository.PorcinoRepository;
import com.javatechie.s3.service.IPorcinoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/porcino")
public class PorcinoController {

    @Autowired
    private IPorcinoService porcinoService;

    @PostMapping
    public Porcino savePorcino(@RequestBody Porcino user) {
        return porcinoService.createPorcino(user);
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
