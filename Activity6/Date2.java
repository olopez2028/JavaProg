public class Date2 {
    private int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private int days;   // days since January 1, 1970

    private Date2(int d) { this.days = d; }

    public Date2(int month, int day, int year) {
        if (month < 1    || month > 12) throw new RuntimeException("Invalid month");
        if (day   < 1    || day   > 31) throw new RuntimeException("Invalid day");
        if (year  < 1970)               throw new RuntimeException("Invalid year");
        days = (year - 1970) * 365 + (day - 1);
        for (int i = 1; i <= month - 1; i++) days += daysInMonth[i];
    }

    // return the next Date
    public Date2 next() { return new Date2(days + 1); }

    // is this Date a after b?
    public boolean isAfter(Date2 b) { return this.days > b.days; }

    public String toString() {
        int year  = 1970 + (days / 365);
        int month, total = 0;
        for (month = 1; month <= 12; month++) {
            total = total + daysInMonth[month];
            if (total > (days % 365)) break;
        }
        int day  = 1 + (days % 365) - total + daysInMonth[month];
        return month + "/" + day + "/" + year;
    }



    // sample client for testing
    public static void main(String[] args) {
        Date2 today = new Date2(5, 31, 2015);
        
        System.out.println("Current Date: " + today);        
        System.out.println("Number of days since January 1, 1970: " + today.days);
        
        System.out.println("Is today the day after May 30, 2015: " + today.isAfter(new Date2(5,30,2015)) + ". Today is: " + today);
        System.out.println("Tomorrow is: " + today.next());                
    }

}