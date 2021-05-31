package kodlamaio.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmByPersonnel;

public interface ConfirmByPersonnelDao extends JpaRepository<ConfirmByPersonnel, Integer>{

}
