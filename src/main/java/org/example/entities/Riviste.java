package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Riviste extends BaseLibreria{

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Riviste() {
    }

    public Riviste(long codISBN, String titolo, int annoPublicazione, int numPagine, Periodicita periodicita) {
        super(codISBN, titolo, annoPublicazione, numPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "periodicita=" + periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
