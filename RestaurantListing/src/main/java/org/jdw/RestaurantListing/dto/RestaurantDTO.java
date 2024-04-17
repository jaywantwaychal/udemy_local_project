package org.jdw.RestaurantListing.dto;

import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RestaurantDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
