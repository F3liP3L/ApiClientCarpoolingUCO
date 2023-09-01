package co.edu.uco.carpooling.repository;

import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Modifying
    @Query(value = "INSERT INTO public.user(id,dni,first_name,second_name,first_surname,second_surname,password,email,phone,rol) " +
            "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void createCustomer(UUID id,String dni,String firstName,String secondName,String firstSurname
                        ,String secondSurname,String password,String companyEmail,Integer phone,int rol);
}
