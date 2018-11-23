package com.mgearapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the BikeFrontSprocket entity.
 */
public class BikeFrontSprocketDTO extends AbstractAuditingDTO implements Serializable {

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

        BikeFrontSprocketDTO bikeFrontSprocketDTO = (BikeFrontSprocketDTO) o;
        if (bikeFrontSprocketDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bikeFrontSprocketDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BikeFrontSprocketDTO{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            "}";
    }
}
