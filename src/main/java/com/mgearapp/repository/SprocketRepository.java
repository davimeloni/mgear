package com.mgearapp.repository;

import com.mgearapp.domain.Sprocket;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Sprocket entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SprocketRepository extends JpaRepository<Sprocket, Long> {

}
