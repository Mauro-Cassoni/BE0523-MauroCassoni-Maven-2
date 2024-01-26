package org.example.entities;

import org.example.DAO.*;

import java.time.LocalDate;

public class Archivio {


    public static void main(String[] args) {

        BaseLibreriaDAO baseLibreriaDAO = new BaseLibreriaDAO();
        LibriDAO libriDAO = new LibriDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();
        RivisteDAO rivisteDAO = new RivisteDAO();
        UtenteDAO utenteDAO = new UtenteDAO();


        Libri libro1 = new Libri();
        libro1.setTitolo("Devil May Cry");
        libro1.setAutore("Dante");
        libro1.setGenere(Genere.FANTASY);
        libro1.setAnnoPublicazione(1995);
        libro1.setNumPagine(426);
        libriDAO.save(libro1);

      Riviste rivista1 = new Riviste();
      rivista1.setTitolo("4 salti in padella");
      rivista1.setPeriodicita(Periodicita.MENSILE);
      rivista1.setAnnoPublicazione(2003);
      rivista1.setNumPagine(55);

      baseLibreriaDAO.save(rivista1);

      Utente utente1 = new Utente();
        utente1.setNome("Mario");
        utente1.setCognome("Rossi");
        utente1.setDataDiNascita(LocalDate.of(1973,10,27));

        utenteDAO.save(utente1);

        Prestito prestito2 = new Prestito();
        prestito2.setUtente(utente1);
        prestito2.setElementoPrestato(libro1);
        prestito2.setDataInizioPrestito(LocalDate.of(2023,01,01));
        prestito2.setDatRestituzioneEffettiva(LocalDate.of(2024,01,01));

            prestitoDAO.save(prestito2);



        System.out.println(baseLibreriaDAO.getByAnno(2003));
        System.out.println(libriDAO.getByAutore("Dante"));
        System.out.println(baseLibreriaDAO.getTitoloList("may"));

        System.out.println(prestitoDAO.getElementiPrestito(552));

        System.out.println(prestitoDAO.getScaduti());



    }


}
