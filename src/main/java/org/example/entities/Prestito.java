package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")


@NamedQuery(name = "getElementiPrestito", query = "select p.elementoPrestato from Prestito p where p.utente.numeroDiTessera = :numero and p.dataRestituzioneEffettiva is null")
@NamedQuery(name = "getScaduti", query = "select x from Prestito x where x.dataRestituzionePrevista < current_date and x.dataRestituzioneEffettiva is null")


public class Prestito {

    @Id
    @Column(name = "id_prestito")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPrestito;

    @ManyToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "elemento_prestato")
    private BaseLibreria elementoPrestato;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(int idPrestito, Utente utente, BaseLibreria elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevita, LocalDate datRestituzioneEffettiva) {
        this.idPrestito = idPrestito;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevita;
        this.dataRestituzioneEffettiva = datRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return
                "idPrestito=" + idPrestito +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva;
    }

    public int getIdPrestito() {
        return idPrestito;
    }

    public void setIdPrestito(int idPrestito) {
        this.idPrestito = idPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public BaseLibreria getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(BaseLibreria elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public LocalDate getDataRestituzionePrevita() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDatRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDatRestituzioneEffettiva(LocalDate datRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = datRestituzioneEffettiva;
    }
}
