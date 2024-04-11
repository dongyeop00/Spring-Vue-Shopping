package dongyeop.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "member")
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

}
