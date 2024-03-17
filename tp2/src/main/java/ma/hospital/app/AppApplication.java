package ma.hospital.app;

import ma.hospital.app.entities.Patient;
import ma.hospital.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		patientRepository.save(new Patient(null, "Adam Watnham", simpleDateFormat.parse("2002/12/20"), true, 21) );
		patientRepository.save(new Patient(null, "Adel Imam", simpleDateFormat.parse("1999/10/30"), true, 10) );
		patientRepository.save(new Patient(null, "Fatime EL", simpleDateFormat.parse("1997/04/03"), true, 50) );
		patientRepository.save(new Patient(null, "Karim Elbarkouk", simpleDateFormat.parse("2000/07/23"), false, 0) );

		System.out.println("All users");
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(System.out::println);
		System.out.println("Selecting user with id: 1");
		Patient p1 = patientRepository.findById(1L).get();
		System.out.println(p1);

		p1.setNom("Adam Eljaabouk");
		patientRepository.save(p1);

		System.out.println("User 1 after update ");
		Patient p1p = patientRepository.findById(1L).get();
		System.out.println(p1p);

		System.out.println("Searching user with name Imam ");
		List<Patient> p2 = patientRepository.search("%Imam%");
		p2.forEach(System.out::println);

		System.out.println("Deleting user: with id 1");
		patientRepository.deleteById(1L);

		System.out.println("All users");
		patients = patientRepository.findAll();
		patients.forEach(System.out::println);

	}
}
