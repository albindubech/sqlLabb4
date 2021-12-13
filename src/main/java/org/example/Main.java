package org.example;

import static org.example.Gender.*;

class Main{

    public static void main( String[] args ) {
        ArtistDao artistDao = new ArtistDaoImpl();

        artistDao.createArtist(new Artist("Miriam", "Bryant", FEMALE, "Pop", 30));
        artistDao.createArtist(new Artist("Tim", "Bergling", MALE, "House", 32));
        artistDao.createArtist(new Artist("Niklas", "Strömstedt", MALE, "Gitarrplonk", 63));
        artistDao.createArtist(new Artist("Carola", "Häggkvist  ", FEMALE, "Disco", 55));

        artistDao.selectByGender(MALE).forEach(System.out::println);

        System.out.println(artistDao.getById(10));

//        artistDao.deleteArtist(artistDao.getById(14));

        Artist artist1 = artistDao.getById(14);
        artist1.setAge(40);
        artistDao.update(artist1);

        artistDao.selectByAgeInterval(40, 65).forEach(System.out::println);

        artistDao.selectByName("Berg").forEach(System.out::println);

        artistDao.selectByGenre("Gitarrplonk").forEach(System.out::println);

        artistDao.selectAll().forEach(System.out::println);
    }
}
