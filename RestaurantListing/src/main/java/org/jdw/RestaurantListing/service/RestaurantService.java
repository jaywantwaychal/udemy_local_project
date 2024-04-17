package org.jdw.RestaurantListing.service;

import org.jdw.RestaurantListing.dto.RestaurantDTO;
import org.jdw.RestaurantListing.entity.Restaurant;
import org.jdw.RestaurantListing.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo  restaurantRepo;


    public List<RestaurantDTO> getAllRestaurants() {
       List<Restaurant> listRestaurant = restaurantRepo.findAll();
       List<RestaurantDTO> listRestaurantDTOS = listRestaurant.stream()
               .map(restaurant -> RestaurantDTO.builder()
                       .id(restaurant.getId())
                       .name(restaurant.getName())
                       .address(restaurant.getAddress())
                       .city(restaurant.getCity())
                       .restaurantDescription(restaurant.getRestaurantDescription())
                       .build())
               .collect(Collectors.toList());
        return listRestaurantDTOS;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = Restaurant.builder()
                .name(restaurantDTO.getName())
                .address(restaurantDTO.getAddress())
                .city(restaurantDTO.getCity())
                .restaurantDescription(restaurantDTO.getRestaurantDescription())
                .build();
        Restaurant restaurantSaved = restaurantRepo.save(restaurant);
        return RestaurantDTO.builder()
                .id(restaurantSaved.getId())
                .name(restaurantSaved.getName())
                .address(restaurantSaved.getAddress())
                .city(restaurantSaved.getCity())
                .restaurantDescription(restaurantSaved.getRestaurantDescription())
                .build();
    }

    public ResponseEntity<RestaurantDTO> getRestaurant(int id) {

        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()) {
            Restaurant restaurantSaved = restaurant.get();

            RestaurantDTO restaurantDTO = RestaurantDTO.builder()
                    .id(restaurantSaved.getId())
                    .name(restaurantSaved.getName())
                    .address(restaurantSaved.getAddress())
                    .city(restaurantSaved.getCity())
                    .restaurantDescription(restaurantSaved.getRestaurantDescription())
                    .build();
            return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
