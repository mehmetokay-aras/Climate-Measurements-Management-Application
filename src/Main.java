public class Main {
    public static void main(String[] args) {
        Temperature deneme = new Temperature(1,2);
        System.out.println(deneme.getMonth());
        System.out.println(deneme.getYear());
        System.out.println(deneme.getFahrenheitMeasurement());
        System.out.println(deneme.toString());
        WindSpeed deneme1 = new WindSpeed(0,6);
        System.out.println(deneme1.getMonthCode());
        System.out.println(deneme1.getKmPerHour());
        System.out.println(deneme1.toString());
    }
}