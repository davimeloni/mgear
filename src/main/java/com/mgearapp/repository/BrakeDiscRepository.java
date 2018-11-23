package com.mgearapp.repository;

import com.mgearapp.domain.BrakeDisc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BrakeDisc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BrakeDiscRepository extends JpaRepository<BrakeDisc, Long> {

}
