package ORM_Hibernate.Example1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Computer {

    @Id // sis laukas zymimas kaip PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Integer ram;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "person_id") //foreign key arba antrinis raktas
    private Person person;

    public Computer(String brand, String model, Integer ram, Integer price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }
}
