package com.example.musicalbum.repository;

import com.example.musicalbum.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "albums")
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
