package uz.pdp.maven.usercruidwithjpql.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import uz.pdp.maven.usercruidwithjpql.entity.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@NamedQuery(
        name = "loginQuery",
        query = "from User u where u.username=:username and u.email = :email and u.password = :password")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Min(value = 18, message = "Yosh {value} dan katta bo'lishi kerak")
    @Max(value = 100, message = "yosh {value} dan kichik bo'lishi kerak")
    private Integer age;

    @Email(regexp = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)", message = "Email formatga mos emas")
    private String email;
}
