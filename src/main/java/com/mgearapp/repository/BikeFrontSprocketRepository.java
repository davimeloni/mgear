package com.mgearapp.repository;

import com.mgearapp.domain.BikeFrontSprocket;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BikeFrontSprocket entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikeFrontSprocketRepository extends JpaRepository<BikeFrontSprocket, Long> {

}
