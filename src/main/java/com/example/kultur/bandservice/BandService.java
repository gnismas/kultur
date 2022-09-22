package com.example.kultur.bandservice;
import com.example.kultur.model.Band;
import com.example.kultur.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BandService implements IBandService {
    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }


    @Override
    public List<Band> findAll() {
        return new ArrayList<>(bandRepository.findAll());
    }

    @Override
    public Band save(Band object) {
        return bandRepository.save(object);
    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return Optional.empty();
    }


}