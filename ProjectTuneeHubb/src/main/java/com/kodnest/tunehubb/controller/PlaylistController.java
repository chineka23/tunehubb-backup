package com.kodnest.tunehubb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehubb.entity.Playlist;
import com.kodnest.tunehubb.entity.Song;
import com.kodnest.tunehubb.service.PlaylistService;
import com.kodnest.tunehubb.service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;
	@PostMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song>songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylists";
	}
	@PostMapping("/addplaylist")
	
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlist table
		playlistService.addplaylist(playlist);
		//updating the song table
		List<Song> songList=playlist.getSongs();
		for (Song s : songList) {
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		return "adminhome";
		
	}
	@PostMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist>allPlaylist = playlistService.fetchAllPlaylists();
		model.addAttribute("allplaylist", allPlaylist);
		return "displayplaylist";
	}

}
