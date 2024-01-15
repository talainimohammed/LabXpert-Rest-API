package org.techlab.labxpert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.techlab.labxpert.Enum.RoleUser;
import org.techlab.labxpert.Enum.StatutEchantillon;
import org.techlab.labxpert.Enum.StatutNumeration;
import org.techlab.labxpert.entity.*;
import org.techlab.labxpert.repository.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class LabXpertApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabXpertApplication.class, args);
	}

	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	EchantillonRepository echantillonRepository;
	@Autowired
	AnalyseRepository analyseRepository;
	@Autowired
	PlanificationRepository planificationRepository;
	@Autowired
	NormeRepository normeRepository;
	@Autowired
	NumerationRepository numerationRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = inputFormat.parse("02/02/1995");
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setNom("med");
		utilisateur.setPrenom("imad");
		utilisateur.setDateNaissance(date);
		utilisateur.setSexe("male");
		utilisateur.setAdresse("qwerty");
		utilisateur.setTel("03251325625");
		utilisateur.setRole(RoleUser.Technicien);
		utilisateur.setPassword("12346");
		utilisateur.setNomUtilisateur("medtala");
		//Utilisateur user=utilisateurRepository.save(utilisateur);
		//System.out.println(utilisateurRepository.findAll());

		Patient patient=new Patient();
		patient.setNom("patient1");
		patient.setPrenom("prenom patient1");
		patient.setDateNaissance(date);
		patient.setSexe("male");
		patient.setAdresse("casa");
		patient.setTel("5454545787");
		//Patient p=patientRepository.save(patient);

		Echantillon echantillon =new Echantillon();
		echantillon.setStatus(StatutEchantillon.EnAttente);
		echantillon.setTypeAnalyse("Hémoglobine");
		//echantillon.setPatient(p);
		//Echantillon ech=echantillonRepository.save(echantillon);

		Analyse analyse =new Analyse();
		analyse.setNomAnalyse(echantillon.getTypeAnalyse());
		//analyse.setEchantillon(ech);
		//Analyse analyse1=analyseRepository.save(analyse);

		Planification planification=new Planification();
		//planification.setAnalyse(analyse1);
		//planification.setUtilisateur(user);
		Date datedebut = inputFormat.parse("12/01/2024");
		Date datefin = inputFormat.parse("13/01/2024");
		planification.setDateDebut(datedebut);
		planification.setDateFin(datefin);
		//Planification plan=planificationRepository.save(planification);
		//System.out.println(plan);

		Numeration numeration=new Numeration();
		//numeration.setAnalyse(analyse1);
		Norme norme=normeRepository.findById(10L).get();
		numeration.setNorme(norme);
		numeration.setValue(80);
		if(numeration.getValue()>=norme.getMinValue() && numeration.getValue()<=norme.getMaxValue()){
			numeration.setStatut(StatutNumeration.Normal);
		}else{
			numeration.setStatut(StatutNumeration.Anormal);
		}
		//Numeration num=numerationRepository.save(numeration);
		//System.out.println(num);
		//Patient p1=patientRepository.findById(p.getId()).get();
		//System.out.println(p1.getEchantillons());

		Fournisseur fournisseur=new Fournisseur();
		fournisseur.setNom("Laboratory A");
		fournisseur.setTel("555-1234");
		fournisseur.setAdresse("123 Main St");
		//fournisseurRepository.save(fournisseur);
	}
}
