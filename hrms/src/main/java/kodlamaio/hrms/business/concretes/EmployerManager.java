package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.MailVerificationService;
import kodlamaio.hrms.core.abstracts.SystemPersonnelControlService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataaccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private MailVerificationService mailVerificationService;
	private SystemPersonnelControlService systemPersonnelControlService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, MailVerificationService mailVerificationService,
			SystemPersonnelControlService systemPersonnelControlService) {
		this.employerDao = employerDao;
	    this.mailVerificationService=mailVerificationService;
		this.systemPersonnelControlService = systemPersonnelControlService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccesDataResult<List<Employer>>(this.employerDao.findAll(),
				"database list has been successfully fetched.");

	}

	@Override
	public Result register(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getPhoneNumber().isEmpty() || employer.getMail().isEmpty()
				|| employer.getPassword().isEmpty() || employer.getWebAdress().isEmpty()) {
			return new ErrorResult("Cannot be left blank.");
		}

		if (employerDao.findByMailEquals(employer.getMail()) != null) {
			return new ErrorResult("Email registered in the system.");
		}

		String email = employer.getMail();
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(employer.getWebAdress())) {
            return new ErrorResult("Your e-mail address and domain do not match");
        }
		
		this.mailVerificationService.mailVerificationCode();

		this.systemPersonnelControlService.systemPersonnelVerifiying(employer);

		this.employerDao.save(employer);
		return new SuccesResult("Employer added.");
	}

}
