package com.codedecode.restaurantlisting.service;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.mapper.RestaurantMapper;
import com.codedecode.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> fetchAllRestaurant(){
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().map(restaurant -> RestaurantMapper.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.mapRestaurantToRestaurantDTO(savedRestaurant);

    }

    public RestaurantDTO fetchRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepo.findById(id).orElse(new Restaurant());
        return RestaurantMapper.mapRestaurantToRestaurantDTO(restaurant);

    }
}
