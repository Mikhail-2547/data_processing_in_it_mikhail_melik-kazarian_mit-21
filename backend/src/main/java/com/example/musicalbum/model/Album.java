package com.example.musicalbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String Title;
    private String Author;
    private String ImageUrl;
}
