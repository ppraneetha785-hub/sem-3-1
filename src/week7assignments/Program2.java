public class Program2 {
    private String[] songs;
    private int count;

    public Program2(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Program2 p = new Program2(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // does not affect original

        System.out.println("Playlist songs:");
        for (String s : p.getSongs()) {
            System.out.println(s);
        }
        System.out.println("Song count = " + p.getSongCount());
    }
}
