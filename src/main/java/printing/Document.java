package printing;

public class Document implements Printable{

    private String file;

    public Document(String file) {
        this.file = file;
    }

    @Override
    public void print() {
        System.out.println("Printing document: " + file);
    }
}
