package utility;

public class DateUtility {

    public static String return_day_from_date(String tenancy_expiry_date, String theday) {
        char[] a = tenancy_expiry_date.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(a[i]);
        }
        String day = sb.toString();
        String dateLocator = theday;
        String newdate = dateLocator.replace("textofdate", day);
        return newdate;
    }
}
