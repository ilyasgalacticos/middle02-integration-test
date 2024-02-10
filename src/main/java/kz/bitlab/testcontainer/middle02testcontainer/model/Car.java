package kz.bitlab.testcontainer.middle02testcontainer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_car")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String manufacturer;

}
