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
 * A BikeBrakeDisc.
 */
@Entity
@Table(name = "bike_brake_disc")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BikeBrakeDisc extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @ManyToMany(mappedBy = "bikeBrakeDiscs")
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

    public BikeBrakeDisc sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public BikeBrakeDisc bikes(Set<Bike> bikes) {
        this.bikes = bikes;
        return this;
    }

    public BikeBrakeDisc addBike(Bike bike) {
        this.bikes.add(bike);
        bike.getBikeBrakeDiscs().add(this);
        return this;
    }

    public BikeBrakeDisc removeBike(Bike bike) {
        this.bikes.remove(bike);
        bike.getBikeBrakeDiscs().remove(this);
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
        BikeBrakeDisc bikeBrakeDisc = (BikeBrakeDisc) o;
        if (bikeBrakeDisc.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bikeBrakeDisc.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BikeBrakeDisc{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            "}";
    }
}
