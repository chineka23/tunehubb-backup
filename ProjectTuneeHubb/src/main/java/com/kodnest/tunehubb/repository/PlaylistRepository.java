package com.kodnest.tunehubb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehubb.entity.Playlist;

public interface PlaylistRepository extends JpaRepository <Playlist, Integer>{

}
