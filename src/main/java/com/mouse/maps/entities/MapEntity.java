package com.mouse.maps.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "map", fetch = FetchType.EAGER)
    private Collection<MapCommentEntity> comments;

    @OneToMany(mappedBy = "map", fetch = FetchType.EAGER)
    private Collection<NoteEntity> notes;

    @OneToMany(mappedBy = "map", fetch = FetchType.EAGER)
    private Collection<MapCompletedEntity> completed;

    @OneToMany(mappedBy = "map", fetch = FetchType.EAGER)
    private Collection<MapFavoriteEntity> favorites;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "maps_tags",
        joinColumns = @JoinColumn(name = "map_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Collection<TagEntity> tags;
}
