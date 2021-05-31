package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.SystemPersonnelControlService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class SystemPersonnelControlManager implements SystemPersonnelControlService {

	@Override
	public boolean systemPersonnelVerifiying(Employer employer) {
		return true;
		
		
	}

	

}
