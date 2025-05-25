package com.example.musicalbum.controller;

import com.example.musicalbum.model.Album;
import com.example.musicalbum.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @GetMapping
    public List<Album> findAllAlbums() {
        return service.findAllAlbums();
    }

    @PostMapping("save_album")
    public String saveAlbum(@RequestBody Album album) {
        service.saveAlbum(album);
        return "Album is successfully saved";
    }

    @PutMapping("update_album")
    public Album updateAlbum(@RequestBody Album album) { return service.updateAlbum(album); }

    @DeleteMapping("delete_album/{id}")
    public void deleteAlbum(@PathVariable Long id) { service.deleteAlbum(id); }
}
