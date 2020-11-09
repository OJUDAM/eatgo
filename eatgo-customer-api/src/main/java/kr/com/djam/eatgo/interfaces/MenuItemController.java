package kr.com.djam.eatgo.interfaces;

import kr.com.djam.eatgo.application.MenuItemService;
import kr.com.djam.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody List<MenuItem> menuItems
    ){

        menuItemService.bulkUpdate(restaurantId,menuItems);
        return "";
    }

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> getMenuItems(@PathVariable("restaurantId") Long restaurantId){

        return menuItemService.getMenuItems(restaurantId);
    }
}
