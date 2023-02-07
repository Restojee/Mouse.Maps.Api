package com.mouse.maps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tips")
@Setter
@Getter
public class TipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
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
