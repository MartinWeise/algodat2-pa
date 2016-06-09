package ad2.ss16.pa;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            String filename = (""+i).length() == 1 ? "0"+i : ""+i;
            Main m = new Main(new String[] {"-t","public_instances/00"+filename});
        }

    }

}
