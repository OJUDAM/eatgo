package kr.com.djam.eatgo.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
