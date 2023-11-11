public class Main {
    public static void main(String[] args) {
        CityMeasurement enviromentalMeasurement = new CityMeasurement();
        System.out.println(enviromentalMeasurement.toString());
        CityMeasurement deneme = new CityMeasurement(2,1);
        System.out.println(deneme.toString());
        CityMeasurement cityMeasurement = new CityMeasurement(deneme);
        System.out.println(deneme.getYearcode());
        System.out.println(cityMeasurement.toString());
        System.out.println(cityMeasurement.equals(deneme));
    }
}