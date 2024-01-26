package it.epicode.week3.day2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "rivista")
public class Rivista extends Articolo {

    private Eperiodicita periodicita;

    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Eperiodicita periodicita) throws Exception {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "articolo: " + super.toString() +
                "periodicita=" + periodicita +
                '}';
    }

    public Eperiodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Eperiodicita periodicita) {
        this.periodicita = periodicita;
    }
}
