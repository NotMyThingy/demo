package com.sumppi.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/* 
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Kahvi extends AbstractPersistable<Long> {

    // PÄÄTIN TALLETTAA KAIKEN TEKSTIMUOTOISENA, KOSKA ESIM. LASKUTOIMITUKSIA EI TARVITTU.
    private String nimi;
    private String paino;
    private String hinta;
    private String paahto;

} */

@Entity
public class Kahvi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Tää tarvitaan!")
    private String nimi;

    @NotBlank(message = "Juu, tää kans!")
    private String paino;

    @NotBlank(message = "Tätä ei tarvii....vai tarviiko?")
    private String hinta;

    @NotBlank(message = "Laita nyt vaan tääkin sinne!")
    private String paahto;

    public Kahvi() {
    }

    public Kahvi(String nimi, String paino, String hinta, String paahto) {
        this.nimi = nimi;
        this.paino = paino;
        this.hinta = hinta;
        this.paahto = paahto;
    }

    public Long getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPaino() {
        return paino;
    }

    public void setPaino(String paino) {
        this.paino = paino;
    }

    public String getHinta() {
        return hinta;
    }

    public void setHinta(String hinta) {
        this.hinta = hinta;
    }

    public String getPaahto() {
        return paahto;
    }

    public void setPaahto(String paahto) {
        this.paahto = paahto;
    }

}