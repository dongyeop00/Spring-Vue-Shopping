package dongyeop.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "item")
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}
