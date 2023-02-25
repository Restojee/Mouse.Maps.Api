package com.mouse.maps.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "created_utc_date")
    private Date createdUtcDate;

    @Column(name = "modified_utc_date")
    private Date modifiedUtcDate;

    @OneToMany(mappedBy = "user")
    private Collection<MapEntity> maps;

    @OneToMany(mappedBy = "user")
    private Collection<MapCommentEntity> comments;

    @OneToMany(mappedBy = "user")
    private Collection<NoteEntity> notes;

    @OneToMany(mappedBy = "user")
    private Collection<TipEntity> tips;

    @OneToMany(mappedBy = "user")
    private Collection<MapCompletedEntity> completed;

    @OneToMany(mappedBy = "user")
    private Collection<MapFavoriteEntity> favorites;
}
