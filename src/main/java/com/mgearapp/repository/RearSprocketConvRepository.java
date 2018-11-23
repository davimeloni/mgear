package com.mgearapp.repository;

import com.mgearapp.domain.RearSprocketConv;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RearSprocketConv entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RearSprocketConvRepository extends JpaRepository<RearSprocketConv, Long> {

}
