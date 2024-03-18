package ma.hospital.app.repository;

import ma.hospital.app.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.nom like :x")
    List<Patient> search(@Param("x") String w);

    Page<Patient> findByNomContains(String mc, Pageable pageable);


    // to find patients with a score greater than a specific score
    List<Patient> findByScoreGreaterThan(int score);
    @Query("select p from  Patient  p where p.score > :x")
    List<Patient> searchByScore(@Param("x") int score);

}
