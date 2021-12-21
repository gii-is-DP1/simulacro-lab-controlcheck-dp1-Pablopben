package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity{
    @Id
    private Integer id;

    @Length(min = 3, max = 50)
    private String name;

    @Min(value = 0)
    private double price;

    @ManyToOne
    @JoinColumn(name = "ptype_id")
    private ProductType productType;
}
