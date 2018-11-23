package com.mgearapp.repository;

import com.mgearapp.domain.BikeBrakeDisc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BikeBrakeDisc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikeBrakeDiscRepository extends JpaRepository<BikeBrakeDisc, Long> {

}
