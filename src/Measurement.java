public class Measurement {
    private String month;
    private int year;
    private int yearcode;
    private int monthCode;
    public Measurement(){
        month ="JANUARY";
        year=2020;
        monthCode = 0;
        yearcode=0;
    }
    public Measurement(int year,int monthCode){
        if (isyearinrange(year) && ismonthinrange(monthCode)) {
            this.monthCode=monthCode;
            this.yearcode = year;
            this.year = initializeyear(year);
            this.month = initializemonth(monthCode);
        }
        else{
            throw new IllegalArgumentException("Measurement outside the range. For year[0-3),for month[0-12)");
        }
    }
    public Measurement(Measurement measurement){
        this.year=measurement.getYear();
        this.yearcode=measurement.getYearcode();
        this.month=measurement.getMonth();
        this.monthCode=measurement.getMonthCode();
    }
    public String getMonth(){return month;}
    public int getYear(){return year;}
    public int getMonthCode(){return monthCode;}
    public int getYearcode(){return yearcode;}
    private boolean isyearinrange(int year){return ((year<3)&&(year>=0));}
    private boolean ismonthinrange(int month){return ((month<12)&&(month>=0));}
    private int initializeyear(int year){
        switch (year) {
            case (0) -> {
                return 2020;
            }
            case (1) -> {
                return 2021;
            }
            case (2) -> {
                return 2022;
            }
        }
        return -1;}
    private String initializemonth(int monthCode){
        switch (monthCode) {
            case (0) -> {
                return "JANUARY";
            }
            case (1) -> {
                return "FEBRUARY";
            }
            case (2) -> {
                return "MARCH";
            }
            case (3) -> {
                return "APRİL";
            }
            case (4) -> {
                return "MAY";
            }
            case (5) -> {
                return "JUNE";
            }
            case (6) -> {
                return "JULY";
            }
            case (7) -> {
                return "AUGUST";
            }
            case (8) -> {
                return "SEPTEMBER";
            }
            case (9) -> {
                return "OCTOBER";
            }
            case (10) -> {
                return "NOVEMBER";
            }
            case (11) -> {
                return "DECEMBER";
            }

        default -> throw new IllegalArgumentException("Invalid month value: " + month);}
    }

    @Override
    public String toString() {
        return "year:"+getYear()+" month:"+getMonth();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Measurement otherMeasurement = (Measurement) obj;
        return year == otherMeasurement.year && month.equals(otherMeasurement.month);
    }
}