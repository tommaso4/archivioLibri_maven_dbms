package it.epicode.week3.day2;

import it.epicode.week3.day2.Dao.ArticoloDao;
import it.epicode.week3.day2.Dao.PrestitoDao;
import it.epicode.week3.day2.Dao.UtenteDao;
import it.epicode.week3.day2.entities.*;

import java.time.LocalDate;
import java.util.List;

public class UsaApp {
    public static void main(String[] args) throws Exception {

        ArticoloDao articoloDao = new ArticoloDao();
        UtenteDao utenteDao = new UtenteDao();
        PrestitoDao prestitoDao = new PrestitoDao();

        Rivista rivista2 = (Rivista) articoloDao.getById(747L);
        Libro libro1 = (Libro) articoloDao.getById(62L);
        Libro libro2 = (Libro) articoloDao.getById(602L);

        Utente utente1 = utenteDao.getById(629L);
        Utente utente2 = utenteDao.getById(65L);
        Utente utente3 = utenteDao.getById(190L);
        Utente utente4 = utenteDao.getById(977L);

        PrestitoArticolo prestitoArticolo1 = prestitoDao.getById(1L);
        PrestitoArticolo prestitoArticolo2 = prestitoDao.getById(2L);


//---------------------------Esercizio-------------------------------
        //1: aggiungi articolo

//                Libro libro3 = new Libro("Soria Moderna", 2000,1110,"Erman Hesse","Storia");
//                articoloDao.save(libro3);
        //2: rimozione con isbn

//        articoloDao.delete(articoloDao.getById(529L));
        //3: ricerca per isbn

        Rivista rivista1 = (Rivista) articoloDao.getById(177L);
        System.out.println(rivista1);
        //4 ricerca per anno

        List<Articolo> articoli = articoloDao.cercaPerAnno(1890);
        articoli.forEach(articolo -> System.out.println(articolo));
        //5 cerca articolo per autore

        List<Articolo> articoli2 = articoloDao.cercaPerAutore("Spinoza");
        articoli2.forEach(articolo -> System.out.println(articolo));
        //6 cerca per titolo o parte di esso
        System.out.println("---------------------6--------------------");

        List<Articolo> articoli3 = articoloDao.cercaPerTitolo("S");
        articoli3.forEach(articolo -> System.out.println(articolo));
        //7 ritorno articolo da prestito aperto e per numero tessera
        System.out.println("-------------------7---------------");

        PrestitoArticolo prestitoArticolo3 = prestitoDao.getById(3L);
        PrestitoArticolo prestitoArticolo4 = prestitoDao.getById(4L);
        prestitoArticolo4.setGetDataRestituzioneEffettiva(null);
        prestitoDao.save(prestitoArticolo4);
        prestitoArticolo3.setGetDataRestituzioneEffettiva(null);
        prestitoDao.save(prestitoArticolo3);
        List<Articolo> articoli4 = prestitoDao.cercaPerNrTesseraEtPrestito(190L);
        articoli4.forEach(articolo -> System.out.println(articolo));

        //8 ricerca di tutti i prestiti scaduti e non restituiti
        System.out.println("------------------8-------------------------");

        List<PrestitoArticolo> prestitoArticoli = prestitoDao.cercaprestitiScadutiEnonRestituiti();
        prestitoArticoli.forEach(prestitoArticolo -> System.out.println(prestitoArticolo));


    }
}








//        Libro libro1 = new Libro("Sidharta", 1890,110,"Erman Hesse","Filosofia");
//        Libro libro2 = new Libro("Braccialetti Azzurri",2002,200,"Spinoza","ROmanzo");
//        Rivista rivista1= new Rivista("SurfCorner",2019,50,Eperiodicita.MENSILE);
//        Rivista rivista2 = new Rivista("Veg",2022,90,Eperiodicita.SETTIMANALE);
//        articoloDao.save(libro1);
//        articoloDao.save(libro2);
//        articoloDao.save(rivista1);
//        articoloDao.save(rivista2);

//        Utente utente1 = new Utente("Mario","Rossi",1991);
//        Utente utente2 = new Utente("Maria","Verdi",1994);
//        Utente utente3 = new Utente("Giacomo","Bianchi",2000);
//        Utente utente4 = new Utente("Vittorio","Giallo",1990);
//        utenteDao.save(utente1);
//        utenteDao.save(utente2);
//        utenteDao.save(utente3);
//        utenteDao.save(utente4);

//        PrestitoArticolo pr1 = new PrestitoArticolo(libro1,utente1,LocalDate.of(2024,9,5),LocalDate.of(2024,10,5));
//        PrestitoArticolo pr2 = new PrestitoArticolo(libro2,utente2,LocalDate.of(2024,9,5),LocalDate.of(2024,9,15));
//        PrestitoArticolo pr3 = new PrestitoArticolo(rivista1,utente3,LocalDate.of(2024,9,5),LocalDate.of(2024,11,5));
//        PrestitoArticolo pr4 = new PrestitoArticolo(rivista2,utente4,LocalDate.of(2024,9,5),LocalDate.of(2024,12,5));
//        prestitoDao.save(pr1);
//        prestitoDao.save(pr2);
//        prestitoDao.save(pr3);
//        prestitoDao.save(pr4);

