public class Main {
    public static void main(String[] args) {
        Temperature deneme1 = new Temperature();
        Temperature deneme2 = new Temperature(30);
        Temperature deneme3 = new Temperature(deneme1);
        System.out.println(deneme1.toString());
        System.out.println(deneme2.toString());
        System.out.println(deneme3.toString());
        System.out.println(deneme1.equals(deneme3));
        WindSpeed deneme4 = new WindSpeed();
        WindSpeed deneme5 = new WindSpeed(50);
        WindSpeed deneme6 = new WindSpeed(deneme4);
        System.out.println(deneme4.toString());
        System.out.println(deneme5.toString());
        System.out.println(deneme6.toString());
        System.out.println(deneme4.equals(deneme6));
        Humidity deneme7 = new Humidity();
        Humidity deneme8 = new Humidity(65);
        Humidity deneme9 = new Humidity(deneme7);
        System.out.println(deneme7.toString());
        System.out.println(deneme8.toString());
        System.out.println(deneme9.toString());
        System.out.println(deneme7.equals(deneme9));
    }
}