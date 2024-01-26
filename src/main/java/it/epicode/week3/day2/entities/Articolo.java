package it.epicode.week3.day2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "articolo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Articolo {

    @Id
    private Long isbn;
    private String titolo;
    @Column(name ="anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;
    @Transient
    static List<Long> isbnList = new ArrayList<>();
    @OneToOne(mappedBy = "articolo")
    private PrestitoArticolo prestito;

    public Articolo(){    }

    public Articolo(String titolo, int annoPubblicazione, int numeroPagine) throws Exception {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.isbn = setIsbn();
    }

    public void setPrestito(PrestitoArticolo prestito) {
        this.prestito = prestito;
    }

    public Long setIsbn() throws Exception {
        Random random = new Random();
        Long possibleIsbn;
        final long maxSpace = 1000L;

        if (isbnList.size() < maxSpace) {
            do {
                possibleIsbn = (long) random.nextInt(1000)+1;
            } while (isbnList.contains(possibleIsbn));

            isbnList.add(possibleIsbn);
            return possibleIsbn;
        } else {
            throw new Exception("No more space in archive");
        }
    }


    @Override
    public String toString() {
        return "Articolo{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
