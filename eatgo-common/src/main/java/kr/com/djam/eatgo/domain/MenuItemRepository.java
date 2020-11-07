package kr.com.djam.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
    MenuItem save(MenuItem menuItem);
    List<MenuItem> findAllByRestaurantId(Long restaurantId);
    void deleteById(Long id);
}