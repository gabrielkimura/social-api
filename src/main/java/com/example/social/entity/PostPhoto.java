package com.example.social.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts_photos", schema = "social")
public class PostPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photos_sq")
    @SequenceGenerator(schema = "social", name = "photos_sq", sequenceName = "photos_sq", allocationSize = 1)
    private Long id;

    @Column(name = "photo_name")
    private String photoName;

    private String url;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post post;
}
