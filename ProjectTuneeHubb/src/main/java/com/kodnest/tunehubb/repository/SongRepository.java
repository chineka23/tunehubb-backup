package com.kodnest.tunehubb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehubb.entity.Song;

public interface SongRepository extends JpaRepository<Song,Integer>{

	Song findByname(String name);

}
