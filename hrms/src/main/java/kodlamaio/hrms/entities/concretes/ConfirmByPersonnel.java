package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data

@PrimaryKeyJoinColumn(name = "confirm_id", referencedColumnName = "user_id")

@Table(name = "confirm_by_personnels")

@AllArgsConstructor
@NoArgsConstructor

public class ConfirmByPersonnel {

	@Id
	
	@Column(name="confirm_id")
	private int confirmId;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;

	@Column(name = "confirm_date")
	private String confirmDate;

}
