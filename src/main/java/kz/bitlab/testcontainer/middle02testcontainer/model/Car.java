package kz.bitlab.testcontainer.middle02testcontainer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_car")
@Getter
@Setter
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String manufacturer;

}
