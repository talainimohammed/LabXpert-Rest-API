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
public class LabXpertApplication{

	public static void main(String[] args) {
		SpringApplication.run(LabXpertApplication.class, args);
	}

}
