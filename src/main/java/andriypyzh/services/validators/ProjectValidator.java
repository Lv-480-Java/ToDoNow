package andriypyzh.services.validators;

import java.sql.Date;
import java.util.Calendar;

public class ProjectValidator {

    public void validateData(String projectName, Date date, String type, String description) {
        if (projectName.isEmpty() || description.isEmpty() || type.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());

        if (date.before(sqldate)) {
            throw new IllegalArgumentException("Illegal date");
        }
    }
}
