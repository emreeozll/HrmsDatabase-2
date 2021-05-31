package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisManager implements MernisService {

	
	@Override
	public void mernisVerifiying(JobSeeker jobSeeker) {

		if(jobSeeker.getFirstName().length()<2 && jobSeeker.getLastName().length()<2) {
			
			System.out.println("Pay attention to the length of the first and last name letters.");
		}
		
		if(jobSeeker.getIdentificationNumber().length()<11) {
			System.out.println("Your ID number must be 11 digits.");
		}
		
		if(jobSeeker.getBirthdayDate().length()<4) {
			System.out.println("Enter a valid year of birth.");
		}
		
		System.out.println("Mernis validation completed successfully.");
	}



}
