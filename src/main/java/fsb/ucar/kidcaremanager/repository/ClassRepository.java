package fsb.ucar.kidcaremanager.repository;

import fsb.ucar.kidcaremanager.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}
