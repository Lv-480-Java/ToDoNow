package andriypyzh.services.validators;

import sun.security.krb5.internal.crypto.Des;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;


public class TaskValidator {

    public void validateData(String taskName, int priority, Date date, String description) {
        if (taskName.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        if (priority < 0) {
            throw new IllegalArgumentException("illegal priority");
        }
        //
//        Date currentDate = Date.valueOf(String.valueOf(LocalDateTime.now()));
//
//        if (date.before(currentDate)) {
//            throw new IllegalArgumentException("Illegal date");
//        }
    }

}
