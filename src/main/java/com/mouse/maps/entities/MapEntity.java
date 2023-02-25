package com.mouse.maps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "maps")
public class MapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @Column(name = "created_utc_date")
    private Date createdUtcDate;

    @Column(name = "modified_utc_date")
    private Date modifiedUtcDate;

    @OneToMany(mappedBy = "map")
    private Collection<MapCommentEntity> comments;

    @OneToMany(mappedBy = "map")
    private Collection<NoteEntity> notes;

    @OneToMany(mappedBy = "map")
    private Collection<MapCompletedEntity> completed;

    @OneToMany(mappedBy = "map")
    private Collection<MapFavoriteEntity> favorites;
}
