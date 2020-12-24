package kr.com.djam.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotNull
    private Long level;

    private Long restaurantId;

    public boolean isAdmin() {
        return level >= 3;
    }

    public boolean isActive() {
        return level > 0;
    }

    public void deactivate() {
        level  = 0L;
    }

    public void setRestaurantId(Long restaurantId){
        this.level = 50L;
        this.restaurantId = restaurantId;
    }

    public boolean isRestaurantOwner(){
        return level == 50L;
    }
}
