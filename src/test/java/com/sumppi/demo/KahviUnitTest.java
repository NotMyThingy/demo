package com.sumppi.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.sumppi.demo.entities.Kahvi;

import org.junit.Test;

public class KahviUnitTest {

    @Test
    public void whenCalledGetName_thenCorrect() {
        Kahvi kofi = new Kahvi("Presta Mokka", "75", "32,99", "4");

        assertThat(kofi.getNimi()).isEqualTo("Presta Mokka");
    }

    @Test
    public void whenCalledGetPaino_thenCorrect() {
        Kahvi kofi = new Kahvi("Presta Mokka", "75", "32,99", "4");

        assertThat(kofi.getPaino()).isEqualTo("75");
    }

    @Test
    public void whenCalledGetHinta_thenCorrect() {
        Kahvi kofi = new Kahvi("Presta Mokka", "75", "32,99", "4");

        assertThat(kofi.getHinta()).isEqualTo("32,99");
    }

    @Test
    public void whenCalledGetPaahto_thenCorrect() {
        Kahvi kofi = new Kahvi("Presta Mokka", "75", "32,99", "4");

        assertThat(kofi.getPaahto()).isEqualTo("4");
    }


}
