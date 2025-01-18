package museum_management_system.Storage.Model;

public class Art {

    private int art_id;
    private String name;
    private String desc;
    private String artist;
    private String length;
    private String height;
    private String image;

    public Art(int art_id, String name, String desc, String artist, String length, String height, String image) {
        this.art_id = art_id;
        this.name = name;
        this.desc = desc;
        this.artist = artist;
        this.length = length;
        this.height = height;
        this.image = image;
    }

    public Art(String name, String desc, String artist, String length, String height) {
        this.name = name;
        this.desc = desc;
        this.artist = artist;
        this.length = length;
        this.height = height;
    }

    public Art() {}

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
