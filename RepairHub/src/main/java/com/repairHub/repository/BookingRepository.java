package com.repairHub.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repairHub.entity.Booking;
import com.repairHub.entity.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
	
	List<Booking> findByCustomer(Customer customer);
}
