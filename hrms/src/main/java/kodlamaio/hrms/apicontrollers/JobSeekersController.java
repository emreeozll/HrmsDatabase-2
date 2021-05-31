package kodlamaio.hrms.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/job_seekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
		
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody JobSeeker jobSeeker) {
		
		return this.jobSeekerService.register(jobSeeker);
		
	}
	
}
