package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Data

@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor

public class JobSeeker extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "birthday_date")
	private String birthdayDate;
	
}
