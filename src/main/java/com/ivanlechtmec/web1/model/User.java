package com.ivanlechtmec.web1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Size(min = 3, max = 50, message = "Имя не должно быть больше 50 и меньше 3 символов")
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;
    @OneToMany(mappedBy = "userOwn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product> products;
}
