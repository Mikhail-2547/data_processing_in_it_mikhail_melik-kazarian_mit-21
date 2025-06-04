package com.example.musicalbum.service;

import com.example.musicalbum.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAllAlbums();
    Album findById(Long id);
    Album saveAlbum(Album album);
    Album updateAlbum(Long id, Album album);
    void deleteAlbum(Long id);
}
