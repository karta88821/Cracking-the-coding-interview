import java.util.*;

public class Data {
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("May", 100));
        songs.add(new Song("Shin", 500));
        songs.add(new Song("Power", 300));
        songs.add(new Song("Power", 300));

        NameCompare nameCompare = new NameCompare();
        Collections.sort(songs, nameCompare);
        for (Song song : songs) {
            System.out.println(song.getName());
        }
        

        System.out.println("=========");

        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songs);
        for (Song song : songSet) {
            System.out.println(song.getName());
        }
    }
}

class NameCompare implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareTo(o2.getName());
    }
    
}

class Song {
    private String name;
    private int price;

    Song(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Song s = (Song) obj;
        return getName().equals(s.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}