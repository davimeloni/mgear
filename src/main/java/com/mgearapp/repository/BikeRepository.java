package com.mgearapp.repository;

import com.mgearapp.domain.Bike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Bike entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query(value = "select distinct bike from Bike bike left join fetch bike.bikeFrontSprockets left join fetch bike.bikeRearSprockets left join fetch bike.rearSprocketConvs left join fetch bike.frontSprocketConvs left join fetch bike.chains left join fetch bike.bikeBrakePads left join fetch bike.bikeBrakeDiscs",
        countQuery = "select count(distinct bike) from Bike bike")
    Page<Bike> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct bike from Bike bike left join fetch bike.bikeFrontSprockets left join fetch bike.bikeRearSprockets left join fetch bike.rearSprocketConvs left join fetch bike.frontSprocketConvs left join fetch bike.chains left join fetch bike.bikeBrakePads left join fetch bike.bikeBrakeDiscs")
    List<Bike> findAllWithEagerRelationships();

    @Query("select bike from Bike bike left join fetch bike.bikeFrontSprockets left join fetch bike.bikeRearSprockets left join fetch bike.rearSprocketConvs left join fetch bike.frontSprocketConvs left join fetch bike.chains left join fetch bike.bikeBrakePads left join fetch bike.bikeBrakeDiscs where bike.id =:id")
    Optional<Bike> findOneWithEagerRelationships(@Param("id") Long id);

}
