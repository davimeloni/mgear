package com.mgearapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A BikeFrontSprocket.
 */
@Entity
@Table(name = "bike_front_sprocket")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BikeFrontSprocket extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @ManyToMany(mappedBy = "bikeFrontSprockets")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Bike> bikes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public BikeFrontSprocket sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public BikeFrontSprocket bikes(Set<Bike> bikes) {
        this.bikes = bikes;
        return this;
    }

    public BikeFrontSprocket addBike(Bike bike) {
        this.bikes.add(bike);
        bike.getBikeFrontSprockets().add(this);
        return this;
    }

    public BikeFrontSprocket removeBike(Bike bike) {
        this.bikes.remove(bike);
        bike.getBikeFrontSprockets().remove(this);
        return this;
    }

    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BikeFrontSprocket bikeFrontSprocket = (BikeFrontSprocket) o;
        if (bikeFrontSprocket.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bikeFrontSprocket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BikeFrontSprocket{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            "}";
    }
}
