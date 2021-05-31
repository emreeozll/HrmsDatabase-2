package kodlamaio.hrms.core.utilities.results;

public class SuccesResult extends Result {

	//işlem sonucu başarılı fakat mesja vermek istemiyor

	public SuccesResult() {
		super(true);
	}
	
	public SuccesResult(String message) {
		super(true,message);
	}
	
	
	
}
