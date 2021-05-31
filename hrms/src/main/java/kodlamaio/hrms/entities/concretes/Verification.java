package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data

@Table(name = "verifications")
@PrimaryKeyJoinColumn(name="verification_id", referencedColumnName = "id")

@AllArgsConstructor
@NoArgsConstructor

public class Verification{


	@Id
    @Column(name ="verification_id")
	private int verificationId;
	
	@Column(name = "verificaiton_code")
	private String verificaitonCode;

	
}
