package org.jdw.RestaurantListing.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
