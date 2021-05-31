package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.MailVerificationService;
import kodlamaio.hrms.core.abstracts.SystemPersonnelControlService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.dataaccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	
	private JobSeekerDao jobSeekerDao;
	private MailVerificationService mailVerificationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MailVerificationService mailVerificationService){
		this.jobSeekerDao = jobSeekerDao;
		this.mailVerificationService = mailVerificationService;
	
	}



	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccesDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "database list has been successfully fetched.");
	}



	@Override
	public Result register(JobSeeker jobSeeker) {
    if(jobSeeker.getBirthdayDate().isEmpty() || jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getIdentificationNumber().isEmpty() || jobSeeker.getMail().isEmpty() || jobSeeker.getPassword().isEmpty())
    { return new ErrorResult("Cannot be left blank.");}
		
    if(jobSeekerDao.findByMailEquals(jobSeeker.getMail())!= null) {
    	return new ErrorResult("Email registered in the system.");
    }
    
    if(jobSeekerDao.findByIdentificationNumberEquals(jobSeeker.getIdentificationNumber())!= null) {
    	return new ErrorResult("IdentificationNumber registered in the system.");
    }
    
         mailVerificationService.mailVerificationCode();
		 this.jobSeekerDao.save(jobSeeker);
		 return new Result(true, "JobSeeker added");
	}
	
	

}
