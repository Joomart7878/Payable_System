package printing;

public class PrintQueue {
    public static boolean printInReversOrder(Printable[] items) {
        System.out.println("Starting print queue in reverse order");
        for (int i = items.length - 1; i >= 0; i--) {
            items[i].print();
        }
        System.out.println("Print queue is completed");
        return false;
    }

    public static void main(String[] args) {
        Printable[] documents = new Printable[3];
        documents[0] = new Document("Document A");
        documents[1] = new Photo("Im photo");
        documents[2] = new Barcode("1234567890");

        System.out.println(printInReversOrder(documents));
    }
}
