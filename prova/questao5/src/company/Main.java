package company;

public class Main {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(12);

        System.out.print(a + " " + b + "\n");

        Integer aux = new Integer(a);
        a = new Integer(b);
        b = new Integer(aux);

        System.out.print(a + " " + b);
    }
}
