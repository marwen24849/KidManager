package fsb.ucar.kidcaremanager.repository;

import fsb.ucar.kidcaremanager.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
