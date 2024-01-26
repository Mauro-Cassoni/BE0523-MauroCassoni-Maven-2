package org.example.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "base_libreria")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@NamedQuery(name = "getByAnno", query = "select b from BaseLibreria b where b.annoPubblicazione = :anno_pubblicazione")
@NamedQuery(name = "getTitoloList", query = "select b from BaseLibreria b where lower (b.titolo) like :titolo")

public abstract class BaseLibreria {

    @Id
    @Column(name = "codice_isbn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")

    private int numPagine;

    public BaseLibreria() {
    }

    public BaseLibreria(long codISBN, String titolo, int annoPublicazione, int numPagine) {
        this.codISBN = codISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPublicazione;
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return
                "codISBN=" + codISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPublicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine;
    }

    public long getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(long codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPubblicazione = annoPublicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }
}
