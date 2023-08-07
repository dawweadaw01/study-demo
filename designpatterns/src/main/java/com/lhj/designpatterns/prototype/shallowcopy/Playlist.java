package com.lhj.designpatterns.prototype.shallowcopy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author banyanmei
 */

@Data
@NoArgsConstructor
public class Playlist implements Serializable,Cloneable {
    private Integer id;
    private String name;
    private List<Song> songs = new ArrayList<>();
    public void addSong(Song song) {
        songs.add(song);
    }

    public Playlist(Playlist playlist) {
        this.id = playlist.id;
        this.name = playlist.name;
        this.songs = playlist.songs;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Playlist playlist = new Playlist();
        playlist.setId(1);
        playlist.setName("aa");
        playlist.addSong(new Song("bb", "cc"));
        System.out.println(playlist);
        Playlist playlist1 = new Playlist(playlist);
        playlist1.addSong(new Song("dd", "ee"));
        System.out.println(playlist1);
        Playlist playlist2 = (Playlist) playlist.clone();
        System.out.println(playlist2);
    }
}
