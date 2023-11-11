public class Main {
    public static void main(String[] args) {
        CityMeasurement enviromentalMeasurement = new CityMeasurement();
        System.out.println(enviromentalMeasurement.toString());
        CityMeasurement deneme = new CityMeasurement(2,1);
        System.out.println(deneme.toString());
        System.out.println("month code:"+deneme.getMonthCode());
        System.out.println("year:"+deneme.getYear());
        CityMeasurement cityMeasurement = new CityMeasurement(deneme);
        System.out.println(cityMeasurement.toString());
    }
}