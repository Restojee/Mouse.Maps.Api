package com.mouse.maps.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "maps_completed")
public class MapCompletedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private MapEntity map;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_utc_date")
    private Date createdUtcDate;

    @Column(name = "modified_utc_date")
    private Date modifiedUtcDate;
}
