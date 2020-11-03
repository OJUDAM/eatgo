package kr.com.djam.eatgo.interfaces;

import kr.com.djam.eatgo.domain.Restaurant;
import kr.com.djam.eatgo.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestarantController {

    private RestaurantRepository respository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = respository.findAll();
        return restaurants;
    }
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = respository.findById(id);
        return restaurant;
    }
}
