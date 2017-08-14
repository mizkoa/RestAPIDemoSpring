package demo.workshop.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepo extends  JpaRepository<Customer,Long> {

}
