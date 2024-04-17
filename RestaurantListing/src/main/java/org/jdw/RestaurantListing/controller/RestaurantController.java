package org.jdw.RestaurantListing.controller;

import org.jdw.RestaurantListing.dto.RestaurantDTO;
import org.jdw.RestaurantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurantDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getRestaurant/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable("id") int id) {
        return restaurantService.getRestaurant(id);
    }

}
