package com.mgearapp.repository;

import com.mgearapp.domain.BrakePad;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BrakePad entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BrakePadRepository extends JpaRepository<BrakePad, Long> {

}
