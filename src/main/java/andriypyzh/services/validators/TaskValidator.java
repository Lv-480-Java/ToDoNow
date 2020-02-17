package andriypyzh.services.validators;

import java.sql.Date;
import java.util.Calendar;

public class TaskValidator {

    public static void validateData(String taskName, int priority, Date date, String description) {
        if (taskName.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        if (!taskName.matches("[A-Za-z0-9_ ^#&.<>\"~;$^%{}?]+")) {
            throw new IllegalArgumentException("Illegal Task Name");
        }
        if (priority < 0) {
            throw new IllegalArgumentException("Illegal Priority");
        }

        Calendar currenttime = Calendar.getInstance();
        Date currentDate = new Date((currenttime.getTime()).getTime());

        if (date.before(currentDate) || date.equals(currentDate)) {
            throw new IllegalArgumentException("Illegal Date");
        }
    }
}
