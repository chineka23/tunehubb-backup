package com.kodnest.tunehubb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehubb.entity.Playlist;
import com.kodnest.tunehubb.entity.Song;
import com.kodnest.tunehubb.repository.PlaylistRepository;
import com.kodnest.tunehubb.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;
	
	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}
	public List<Playlist> fetchAllPlaylists(){
		List<Playlist>allplaylist=playlistRepository.findAll();
		return allplaylist;
		
	}



}
