package com.example.musicalbum.service.Impl;

import com.example.musicalbum.model.Album;
import com.example.musicalbum.repository.AlbumRepository;
import com.example.musicalbum.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository repository;

    @Override
    public List<Album> findAllAlbums() {
        return repository.findAll();
    }

    public Album findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Album saveAlbum(Album album) {
        return repository.save(album);
    }

    @Override
    public Album updateAlbum(Long id, Album album) {
        if (repository.existsById(id)) {
            album.setId(id);
            return repository.save(album);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAlbum(Long id) {
        repository.deleteById(id);
    }
}
