package com.example.kultur.controller;

import com.example.kultur.bandservice.IBandService;
import com.example.kultur.model.Band;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BandController {

    private IBandService iBandService;

    public BandController(IBandService bandService) {
        this.iBandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> create(@RequestBody Band band) {
        List<Band> bandList = iBandService.findAll();
        for (Band value : bandList) {
            if (value.getName().equalsIgnoreCase(band.getName())) {
                return new ResponseEntity<>(band.getName() + " already exist", HttpStatus.OK);
            }
        }
        iBandService.save(band);
        return new ResponseEntity<>("New Band: " + band.getName() + " created", HttpStatus.OK);
    }
}