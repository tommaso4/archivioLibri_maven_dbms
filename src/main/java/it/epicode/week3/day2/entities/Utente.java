package it.epicode.week3.day2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @Column(name = "numero_tessera")
    private Long numeroTessera;
    private String nome;
    private String cognome;
    @Column(name = "anno_di_nascita")
    private int annoDiNascita;
    @Column(name = "lista_prestiti")
    @OneToMany(mappedBy = "utente",cascade = CascadeType.ALL)
    private List<PrestitoArticolo> listaPrestiti;

    @Transient
    private List<Long> listaTessere = new ArrayList<>();

    public Utente() {
    }

    public Utente(String nome, String cognome, int annoDiNascita) throws Exception {
        this.nome = nome;
        this.cognome = cognome;
        this.annoDiNascita = annoDiNascita;
        this.numeroTessera = setNumTessera();
    }

    public Long setNumTessera() throws Exception {
        Random random = new Random();
        Long possibleTessera;
        final long maxSpace = 1000L;

        if (listaTessere.size() < maxSpace) {
            do {
                possibleTessera = (long) random.nextInt(1000) + 1;
            } while (listaTessere.contains(possibleTessera));

            listaTessere.add(possibleTessera);
            return possibleTessera;
        } else {
            throw new Exception("No more space in archive");
        }
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", annoDiNascita=" + annoDiNascita +
                ", numeroTessera=" + numeroTessera +
                '}';
    }

    public Long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(Long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    public void setAnnoDiNascita(int annoDiNascita) {
        this.annoDiNascita = annoDiNascita;
    }
}
