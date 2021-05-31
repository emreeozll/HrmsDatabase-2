package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.dataaccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	
    private JobPositionDao jobPositionsDao;
    
 
   
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionsDao) {
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccesDataResult<List<JobPosition>>(this.jobPositionsDao.findAll(), "database list has been successfully fetched.");
	}

	@Override
	public Result register(JobPosition jobPosition) {
		if(jobPositionsDao.findByJobNameEquals(jobPosition.getJobName())!=null) {
			return new ErrorResult("This job name exists in the system");
		}
		
		this.jobPositionsDao.save(jobPosition);
		return new SuccesDataResult(jobPosition,"Job Position Added");
	}
}
