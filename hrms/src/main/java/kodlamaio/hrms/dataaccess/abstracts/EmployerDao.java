package kodlamaio.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

 	Employer findByMailEquals(String mail);
	Employer findByWebAdressEquals(String webAdress);
	Employer findByPhoneNumberEquals(String phoneNumber);
}
