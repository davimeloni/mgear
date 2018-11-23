package com.mgearapp.repository;

import com.mgearapp.domain.BikeBrakePad;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BikeBrakePad entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikeBrakePadRepository extends JpaRepository<BikeBrakePad, Long> {

}
