package com.mgearapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the BikeRearSprocket entity.
 */
public class BikeRearSprocketDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    private String sku;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BikeRearSprocketDTO bikeRearSprocketDTO = (BikeRearSprocketDTO) o;
        if (bikeRearSprocketDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bikeRearSprocketDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BikeRearSprocketDTO{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            "}";
    }
}
