package com.example.rentacar.repository;

import com.example.rentacar.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {


    // hata olduğunda işlemi geri alır.
    //    @Transactional
    //    void deleteByRentalId(int rentalId);

}
