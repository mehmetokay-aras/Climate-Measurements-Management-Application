public class Main {
    public static void main(String[] args) {
        Temperature deneme1 = new Temperature();
        Temperature deneme2 = new Temperature(30);
        Temperature deneme3 = new Temperature(deneme1);
        System.out.println(deneme1.toString());
        System.out.println(deneme2.toString());
        System.out.println(deneme3.toString());
        Temperature deneme4 = new Temperature(65);
    }
}