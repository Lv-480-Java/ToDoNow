package andriypyzh.services.validators;

import java.sql.Date;
import java.util.Calendar;

public class ProjectValidator {

    public void validateData(String projectName, Date date, String type, String description) {
        if (projectName.isEmpty() || description.isEmpty() || type.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        if (!projectName.matches("[A-Za-z0-9_ ]+")) {
            throw new IllegalArgumentException("Illegal taskName");
        }

        Calendar currenttime = Calendar.getInstance();
        Date currentDate = new Date((currenttime.getTime()).getTime());

        if (date.before(currentDate) || date.equals(currentDate)) {
            throw new IllegalArgumentException("Illegal date");
        }
    }
}
