package com.sumppi.demo.repositories;

import com.sumppi.demo.entities.Kahvi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KahviRepository extends JpaRepository<Kahvi, Long> {

}