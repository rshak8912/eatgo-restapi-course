package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty @Setter
    private String email;

    @NotEmpty @Setter
    private String name;

    @NotNull @Setter
    private Long level;

    private String password;

    private Long restaurantId;

    public boolean isAdmin() {
        return level >= 100L;
    }
    public boolean isActive() {
        return level > 0;
    }

    public void deactive() {
        level = 0L;
    }

    public void setRestaurantId(Long restaurantId) {
        this.level = 50L;
        this.restaurantId = restaurantId;
    }

    public boolean isRestaurantOwner() {
        return level == 50L;
    }

}
