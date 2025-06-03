package com.example.musicalbum.repository;

import com.example.musicalbum.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
