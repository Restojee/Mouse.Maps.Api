package com.mouse.maps.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "maps_comments")
public class MapCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private MapEntity map;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "created_utc_date")
    private Date createdUtcDate;

    @Column(name = "modified_utc_date")
    private Date modifiedUtcDate;
}
