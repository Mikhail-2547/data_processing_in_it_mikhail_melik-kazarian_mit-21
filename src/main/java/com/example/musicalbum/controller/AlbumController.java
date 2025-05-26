package com.example.musicalbum.controller;

import com.example.musicalbum.model.Album;
import com.example.musicalbum.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumService service;

//    @GetMapping
//    public List<Album> findAllAlbums() {
//        return service.findAllAlbums();
//    }

//    @PostMapping("save_album")
//    public String saveAlbum(@RequestBody Album album) {
//        service.saveAlbum(album);
//        return "Album is successfully saved";
//    }

//    @PutMapping("update_album")
//    public Album updateAlbum(@RequestBody Album album) { return service.updateAlbum(album); }
//
//    @DeleteMapping("delete_album/{id}")
//    public void deleteAlbum(@PathVariable Long id) { service.deleteAlbum(id); }

    @GetMapping
    public String listAlbums(Model model) {
        model.addAttribute("albums", service.findAllAlbums());
        return "album-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("album", new Album());
        return "album-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Album album = service.findAlbumById(id);
        model.addAttribute("album", album);
        return "album-form";
    }

    @PostMapping("/save")
    public String saveAlbum(@ModelAttribute("album") Album album) {
        service.saveAlbum(album);
        return "redirect:/albums";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        service.deleteAlbum(id);
        return "redirect:/albums";
    }
}
