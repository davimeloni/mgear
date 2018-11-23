package com.mgearapp.repository;

import com.mgearapp.domain.BikeRearSprocket;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BikeRearSprocket entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikeRearSprocketRepository extends JpaRepository<BikeRearSprocket, Long> {

}
