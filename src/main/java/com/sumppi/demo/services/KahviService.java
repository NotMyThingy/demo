package com.sumppi.demo.services;

import com.sumppi.demo.entities.Kahvi;
import com.sumppi.demo.repositories.KahviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KahviService {

    @Autowired
    private KahviRepository kahviRepository;

    public void saveKofi(Kahvi kahvi) {
        this.kahviRepository.save(kahvi);
    }

    public void deleteKofi(Kahvi kahvi) {
        this.kahviRepository.delete(kahvi);
    }

}
