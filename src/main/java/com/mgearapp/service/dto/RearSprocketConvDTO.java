package com.mgearapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the RearSprocketConv entity.
 */
public class RearSprocketConvDTO extends AbstractAuditingDTO implements Serializable {

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

        RearSprocketConvDTO rearSprocketConvDTO = (RearSprocketConvDTO) o;
        if (rearSprocketConvDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rearSprocketConvDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RearSprocketConvDTO{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            "}";
    }
}
