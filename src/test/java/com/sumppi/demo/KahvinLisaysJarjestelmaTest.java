package com.sumppi.demo;

import static org.junit.Assert.*;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KahvinLisaysJarjestelmaTest extends FluentTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void canAddMoarKoffee() {

        // Avaa sivu "/kofi"
        goTo("http://localhost:" + port + "/kofi");

        // Varmistetaan ettei 'Miun kahveissa' ole Lavazzaa
        // assertFalse(pageSource().contains("Lavazza"));
        assertFalse(pageSource().contains("Das Mocca"));

        // täytetään lomakkeen kentät
        find("#name").fill().with("Das Mocca");
        find("#weight").fill().with("250");
        find("#price").fill().with("12,90");
        find("#roast").fill().with("4");

        // Lomakkeen lähetys
        find("form").first().submit();

        // Varmista, että sivulle on lisätty uusi kahvi
        assertTrue(pageSource().contains("Das Mocca"));
        assertTrue(pageSource().contains("250"));
        assertTrue(pageSource().contains("12.90"));
        assertTrue(pageSource().contains("4"));

    }
}
