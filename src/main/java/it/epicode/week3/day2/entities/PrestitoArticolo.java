package it.epicode.week3.day2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito_articolo")
public class PrestitoArticolo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private Utente utente;
    @OneToOne
    @JoinColumn(name = "articolo_id")
    private Articolo articolo;
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    @Column(name = "data_res_prev")
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_res_eff")
    private LocalDate getDataRestituzioneEffettiva;
    public PrestitoArticolo(){}

    public PrestitoArticolo(Articolo articolo,Utente utente, LocalDate dataInizio, LocalDate getDataRestituzioneEffettiva) {
        this.articolo = articolo;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusMonths(1);
        this.getDataRestituzioneEffettiva = getDataRestituzioneEffettiva;
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "PrestitoArticolo{" +
                "id=" + id +
                ", utente=" + utente +
                ", articolo=" + articolo +
                ", dataInizio=" + dataInizio +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", getDataRestituzioneEffettiva=" + getDataRestituzioneEffettiva +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getGetDataRestituzioneEffettiva() {
        return getDataRestituzioneEffettiva;
    }

    public void setGetDataRestituzioneEffettiva(LocalDate getDataRestituzioneEffettiva) {
        this.getDataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }
}
