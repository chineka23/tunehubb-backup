package com.kodnest.tunehubb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehubb.entity.Song;
import com.kodnest.tunehubb.repository.SongRepository;
import com.kodnest.tunehubb.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongRepository songRepository;
	@Override
	public String addSong(Song song) {
		songRepository.save(song);
		return "Song added successfully";
	}
	@Override
	public List<Song>fetchAllSongs(){
		List<Song> songs = songRepository.findAll();
		return songs;
	}
	@Override
	public boolean songExists(String name) {
		Song song = songRepository.findByname(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
		
	}
}
