package org.example;

import java.util.List;

interface ArtistDao {

    void createArtist(Artist artist);
    Artist getById(int id);
    void deleteArtist(Artist artist);
    void update(Artist artist);
    List<Artist> selectAll();
    List<Artist> selectByAgeInterval(int from, int to);
    List<Artist> selectByName(String name);
    List<Artist> selectByGenre(String genre);
    List<Artist> selectByGender(Gender gender);

}
