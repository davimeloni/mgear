package com.mgearapp.repository;

import com.mgearapp.domain.Chain;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Chain entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChainRepository extends JpaRepository<Chain, Long> {

    @Query("SELECT c FROM Chain c WHERE LOWER(c.sku) = LOWER(:sku)")
    public Chain find(@Param("sku") String sku );

}
