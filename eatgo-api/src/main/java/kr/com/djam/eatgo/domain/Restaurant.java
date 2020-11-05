package kr.com.djam.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

   /* private String regionName;
    private String categoryName;
    private String tagNames;
*/
    @Transient
    private List<MenuItem> menuItems;



    public String getInformation() {
        return name+" in "+ address;
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }


    public void setMenuItem(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }


    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
