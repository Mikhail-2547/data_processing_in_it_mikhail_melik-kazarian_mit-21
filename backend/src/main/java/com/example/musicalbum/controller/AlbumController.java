package com.example.musicalbum.controller;

import com.example.musicalbum.model.Album;
import com.example.musicalbum.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @GetMapping
    public List<Album> findAllAlbums() {
        return service.findAllAlbums();
    }

    @GetMapping("/{id}")
    public Album findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("save_album")
    public String saveAlbum(@RequestBody Album album) {
        service.saveAlbum(album);
        return "Album is successfully saved";
    }

    @PutMapping("/update")
    public Album updateAlbum(@RequestBody Album album) { return service.updateAlbum(album); }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id) { service.deleteAlbum(id); }
}
