package com.ettaleby.mbarek.examjeesdia;

import com.ettaleby.mbarek.examjeesdia.entities.*;
import com.ettaleby.mbarek.examjeesdia.enums.*;
import com.ettaleby.mbarek.examjeesdia.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ExamJeeSdiaApplication implements CommandLineRunner {

    @Autowired
    private AgenceRepository agenceRepo;
    @Autowired
    private VoitureRepository voitureRepo;
    @Autowired
    private MotoRepository motoRepo;
    @Autowired
    private LocationRepository locationRepo;

    public static void main(String[] args) {
        SpringApplication.run(ExamJeeSdiaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Agence agenceCentre = new Agence(null, "Agence Centre-Ville", "15 Av. Hassan II", "Casablanca", "0522-123456", new ArrayList<>());
        Agence agenceMarina = new Agence(null, "Agence Marina", "8 Boulevard de la Corniche", "Casablanca", "0522-654321", new ArrayList<>());
        Agence agenceRabat = new Agence(null, "Agence Rabat Gare", "Place de la Gare", "Rabat", "0537-112233", new ArrayList<>());

        agenceCentre = agenceRepo.save(agenceCentre);
        agenceMarina = agenceRepo.save(agenceMarina);
        agenceRabat = agenceRepo.save(agenceRabat);

        Voiture clio = new Voiture();
        clio.setMarque("Renault");
        clio.setModele("Clio 5");
        clio.setMatricule("1234-أ-75");
        clio.setPrixParJour(450.0);
        clio.setDateMiseEnService(LocalDate.of(2024, 1, 15));
        clio.setStatut(StatutVehicule.DISPONIBLE);
        clio.setNombrePortes(5);
        clio.setTypeCarburant(TypeCarburant.ESSENCE);
        clio.setBoiteVitesse(BoiteVitesse.MANUELLE);
        clio.setAgence(agenceCentre);

        Voiture peugeot = new Voiture();
        peugeot.setMarque("Peugeot");
        peugeot.setModele("3008");
        peugeot.setMatricule("5678-ب-99");
        peugeot.setPrixParJour(700.0);
        peugeot.setDateMiseEnService(LocalDate.of(2023, 8, 22));
        peugeot.setStatut(StatutVehicule.LOUE);
        peugeot.setNombrePortes(5);
        peugeot.setTypeCarburant(TypeCarburant.DIESEL);
        peugeot.setBoiteVitesse(BoiteVitesse.AUTOMATIQUE);
        peugeot.setAgence(agenceMarina);

        Voiture toyota = new Voiture();
        toyota.setMarque("Toyota");
        toyota.setModele("Yaris Cross");
        toyota.setMatricule("9012-ج-10");
        toyota.setPrixParJour(550.0);
        toyota.setDateMiseEnService(LocalDate.of(2024, 3, 10));
        toyota.setStatut(StatutVehicule.EN_MAINTENANCE);
        toyota.setNombrePortes(5);
        toyota.setTypeCarburant(TypeCarburant.HYBRIDE);
        toyota.setBoiteVitesse(BoiteVitesse.AUTOMATIQUE);
        toyota.setAgence(agenceCentre);

        Voiture tesla = new Voiture();
        tesla.setMarque("Tesla");
        tesla.setModele("Model 3");
        tesla.setMatricule("3456-د-200");
        tesla.setPrixParJour(1200.0);
        tesla.setDateMiseEnService(LocalDate.of(2025, 1, 5));
        tesla.setStatut(StatutVehicule.DISPONIBLE);
        tesla.setNombrePortes(4);
        tesla.setTypeCarburant(TypeCarburant.ELECTRIQUE);
        tesla.setBoiteVitesse(BoiteVitesse.AUTOMATIQUE);
        tesla.setAgence(agenceRabat);

        clio = voitureRepo.save(clio);
        peugeot = voitureRepo.save(peugeot);
        toyota = voitureRepo.save(toyota);
        tesla = voitureRepo.save(tesla);

        Moto honda = new Moto();
        honda.setMarque("Honda");
        honda.setModele("CB 500F");
        honda.setMatricule("1111-أ-50");
        honda.setPrixParJour(300.0);
        honda.setDateMiseEnService(LocalDate.of(2023, 9, 1));
        honda.setStatut(StatutVehicule.DISPONIBLE);
        honda.setCylindree(471);
        honda.setTypeMoto(TypeMoto.ROADSTER);
        honda.setCasqueInclus(CasqueInclus.OUI);
        honda.setAgence(agenceCentre);

        Moto yamaha = new Moto();
        yamaha.setMarque("Yamaha");
        yamaha.setModele("YZF-R6");
        yamaha.setMatricule("2222-ب-150");
        yamaha.setPrixParJour(500.0);
        yamaha.setDateMiseEnService(LocalDate.of(2024, 5, 20));
        yamaha.setStatut(StatutVehicule.LOUE);
        yamaha.setCylindree(599);
        yamaha.setTypeMoto(TypeMoto.SPORTIVE);
        yamaha.setCasqueInclus(CasqueInclus.NON);
        yamaha.setAgence(agenceMarina);

        Moto vespa = new Moto();
        vespa.setMarque("Piaggio");
        vespa.setModele("Vespa GTS 300");
        vespa.setMatricule("3333-ج-200");
        vespa.setPrixParJour(200.0);
        vespa.setDateMiseEnService(LocalDate.of(2022, 7, 18));
        vespa.setStatut(StatutVehicule.DISPONIBLE);
        vespa.setCylindree(278);
        vespa.setTypeMoto(TypeMoto.SCOOTER);
        vespa.setCasqueInclus(CasqueInclus.OUI);
        vespa.setAgence(agenceRabat);

        Moto bmw = new Moto();
        bmw.setMarque("BMW");
        bmw.setModele("R 1250 GS");
        bmw.setMatricule("4444-د-75");
        bmw.setPrixParJour(800.0);
        bmw.setDateMiseEnService(LocalDate.of(2023, 3, 14));
        bmw.setStatut(StatutVehicule.EN_MAINTENANCE);
        bmw.setCylindree(1254);
        bmw.setTypeMoto(TypeMoto.TOURING);
        bmw.setCasqueInclus(CasqueInclus.OUI);
        bmw.setAgence(agenceCentre);

        honda = motoRepo.save(honda);
        yamaha = motoRepo.save(yamaha);
        vespa = motoRepo.save(vespa);
        bmw = motoRepo.save(bmw);


        Location loc1 = new Location();
        loc1.setDateDebut(LocalDate.now().minusDays(10));
        loc1.setDateFin(LocalDate.now().minusDays(5));
        loc1.setPrixTotal(5 * clio.getPrixParJour());
        loc1.setVehicule(clio);

        Location loc2 = new Location();
        loc2.setDateDebut(LocalDate.now().minusDays(2));
        loc2.setDateFin(LocalDate.now().plusDays(5));
        loc2.setPrixTotal(7 * peugeot.getPrixParJour());
        loc2.setVehicule(peugeot);

        Location loc3 = new Location();
        loc3.setDateDebut(LocalDate.now().minusDays(1));
        loc3.setDateFin(LocalDate.now().plusDays(2));
        loc3.setPrixTotal(3 * yamaha.getPrixParJour());
        loc3.setVehicule(yamaha);

        Location loc4 = new Location();
        loc4.setDateDebut(LocalDate.now().plusDays(10));
        loc4.setDateFin(LocalDate.now().plusDays(15));
        loc4.setPrixTotal(5 * tesla.getPrixParJour());
        loc4.setVehicule(tesla);

        Location loc5 = new Location();
        loc5.setDateDebut(LocalDate.now().minusDays(20));
        loc5.setDateFin(LocalDate.now().minusDays(15));
        loc5.setPrixTotal(5 * honda.getPrixParJour());
        loc5.setVehicule(honda);

        Location loc6 = new Location();
        loc6.setDateDebut(LocalDate.now().minusDays(8));
        loc6.setDateFin(LocalDate.now().minusDays(6));
        loc6.setPrixTotal(2 * vespa.getPrixParJour());
        loc6.setVehicule(vespa);

        Location loc7 = new Location();
        loc7.setDateDebut(LocalDate.now().minusDays(3));
        loc7.setDateFin(LocalDate.now().plusDays(2));
        loc7.setPrixTotal(5 * clio.getPrixParJour());
        loc7.setVehicule(clio);

        locationRepo.save(loc1);
        locationRepo.save(loc2);
        locationRepo.save(loc3);
        locationRepo.save(loc4);
        locationRepo.save(loc5);
        locationRepo.save(loc6);
        locationRepo.save(loc7);


    }
}