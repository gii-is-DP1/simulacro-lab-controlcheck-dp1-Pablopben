package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.type.TrueFalseType;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductType extends BaseEntity{

    @Size(min = 3, max = 50)
    @NotEmpty
    @Column(name = "name", unique = true)
    String name;
}
