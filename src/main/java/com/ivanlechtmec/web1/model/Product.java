package com.ivanlechtmec.web1.model;

import com.ivanlechtmec.web1.repository.UserRepository;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "p_product")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "details")
    String details;
    @Column(name = "price")
    Integer price;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User userOwn;




}
