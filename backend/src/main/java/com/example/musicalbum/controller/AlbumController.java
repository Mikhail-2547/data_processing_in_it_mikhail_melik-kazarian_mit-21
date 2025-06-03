package com.example.musicalbum.controller;

import com.example.musicalbum.model.Album;
import com.example.musicalbum.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @Operation(summary = "Get all albums")
    @GetMapping
    public List<Album> findAllAlbums() {
        log.info("[ GET /albums ] :: get all albums' list");
        return service.findAllAlbums();
    }

    @Operation(summary = "Get album by ID")
    @GetMapping("/{id}")
    public Album findById(@PathVariable Long id) {
        log.info("[ GET /albums/{} ] :: get album by id", id);
        return service.findById(id);
    }

    @Operation(summary = "Create new album")
    @PostMapping
    public String saveAlbum(@RequestBody Album album) {
        service.saveAlbum(album);
        log.info("[ POST /albums ] :: added new album: {}", album.getTitle());
        return "Album is successfully saved";
    }

    @Operation(summary = "Update album by id")
    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        log.info("[ PUT /albums/{} ] :: album update request", id);

        Album updated = service.updateAlbum(id, album);

        if (updated == null) {
            log.info("[ FAILURE ] :: album with id {} doesn't exist", id);
        } else {
            log.info("[ SUCCESS ] :: album with id {} is updated", id);
        }

        return updated;
    }

    @Operation(summary = "Delete album by id")
    @DeleteMapping("delete_album/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        log.info("[ DELETE /albums/{} ] album is deleted by id", id);
        service.deleteAlbum(id);
    }
}
