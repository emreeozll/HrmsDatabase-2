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
@Table(name = "system_personnels")
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnel extends User{


	@Column(name = "personnel_title")
	private String personnelTitle;
}
