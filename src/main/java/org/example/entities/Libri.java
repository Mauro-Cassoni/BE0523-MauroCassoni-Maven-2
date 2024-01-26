package org.example.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "libri")

@NamedQuery(name = "getByAutore", query = "select b from Libri b where b.autore = :autore")

public class Libri extends BaseLibreria {

    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;


    public Libri() {
    }


    public Libri(long codISBN, String titolo, int annoPublicazione, int numPagine, String autore, Genere genere) {
        super(codISBN, titolo, annoPublicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() +
                "autore='" + autore + '\'' +
                ", genere=" + genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
