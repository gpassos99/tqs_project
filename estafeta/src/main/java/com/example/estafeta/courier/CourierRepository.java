package com.example.estafeta.courier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    //@Query(select s from Courier s where email = ?1)
    Optional<Courier> findCourierByEmail(String email);
}

