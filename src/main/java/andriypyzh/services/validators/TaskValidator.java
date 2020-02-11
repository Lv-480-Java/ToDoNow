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
        ///
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        java.util.Date date1 = new java.util.Date();
//        if (date.compareTo() < 0) {
//            throw new IllegalArgumentException("Illegal date");
//        }
    }

}
