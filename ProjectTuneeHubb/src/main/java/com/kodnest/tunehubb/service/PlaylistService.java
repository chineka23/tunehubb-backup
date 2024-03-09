package com.kodnest.tunehubb.service;

import java.util.List;

import com.kodnest.tunehubb.entity.Playlist;

public interface PlaylistService {

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
