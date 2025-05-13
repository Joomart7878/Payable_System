package printing;

public class Photo implements Printable{

    private String picture;

    public Photo(String picture) {
        this.picture = picture;
    }

    @Override
    public void print() {
        System.out.println("Photo printed in color: " + picture);
    }
}
