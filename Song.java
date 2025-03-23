package Assignment;

// Enum untuk Genre
enum Genre {
    UNDEFINED(0), POP(1), ROCK(2), HIP_HOP(3), RNB(4), JAZZ(5), INSTRUMENTALS(6), CLOWNCORE(7);

    private final int value;

    Genre(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Genre fromInt(int i) {
        for (Genre g : Genre.values()) {
            if (g.getValue() == i) {
                return g;
            }
        }
        return UNDEFINED;
    }
}

// Kelas Artist
class Artist {
    private String name;
    private String alias;
    private String imageURL;

    public Artist(String name, String alias, String imageURL) {
        this.name = name;
        this.alias = alias;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getImageURL() {
        return imageURL;
    }
}

// Kelas Album
class Album {
    private String name;
    private String coverURL;

    public Album(String name, String coverURL) {
        this.name = name;
        this.coverURL = coverURL;
    }

    public String getName() {
        return name;
    }

    public String getCoverURL() {
        return coverURL;
    }
}

// Kelas Song
public class Song {

    private String id;
    private String title;
    private String releaseYear;
    private String musicFileURL;
    private Genre genre;

    private Album album;
    private Artist artist;

    public Song(String id, String title, String releaseYear, String musicFileURL) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.musicFileURL = musicFileURL;
        this.genre = Genre.UNDEFINED;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void printInfo(int detailLevel) {
        switch (detailLevel) {
            case 0:
                printSongInfo();
                break;
            case 1:
                printSongInfo();
                if (artist != null) {
                    printArtistInfo();
                }
                break;
            case 2:
                printSongInfo();
                if (album != null) {
                    printAlbumInfo();
                }
                break;
            case 3:
                printSongInfo();
                if (artist != null) {
                    printArtistInfo();
                }
                if (album != null) {
                    printAlbumInfo();
                }
                break;
        }
    }

    private void printSongInfo() {
        System.out.println("Song title: " + title);
        System.out.println("Release year: " + releaseYear);
        if (genre != Genre.UNDEFINED) {
            System.out.println("Genre: " + genre);
        }
    }

    private void printArtistInfo() {
        System.out.println("Artist name: " + artist.getName());
        System.out.println("Artist alias: " + artist.getAlias());
    }

    private void printAlbumInfo() {
        System.out.println("Album name: " + album.getName());
        System.out.println("Album cover: " + album.getCoverURL());
    }
}