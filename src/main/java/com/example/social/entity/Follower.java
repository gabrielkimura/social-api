package com.example.social.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "followers", schema = "social")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "followers_sq")
    @SequenceGenerator(schema = "social", name = "followers_sq", sequenceName = "followers_sq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followers_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
