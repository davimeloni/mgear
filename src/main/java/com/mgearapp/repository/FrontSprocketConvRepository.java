package com.mgearapp.repository;

import com.mgearapp.domain.FrontSprocketConv;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FrontSprocketConv entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FrontSprocketConvRepository extends JpaRepository<FrontSprocketConv, Long> {

}
