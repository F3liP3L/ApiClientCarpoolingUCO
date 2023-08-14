package co.edu.uco.crosscutting.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class UtilDate {

    private static final Time TIME = Time.valueOf(LocalTime.now());

    private static final UtilDate INSTANCE = new UtilDate();

    public static UtilDate getUtilDate() {
        return INSTANCE;
    }

    public boolean isNull(Date date) {
        return getUtilObject().isNull(date);
    }

    public Date getDefaultIsNull(Date value) {
        return getUtilObject().getDefaultIsNull(value, new Date());
    }


    public Time getDefaultTime(Time value, Time defaultValue) {
        return getUtilObject().getDefaultIsNull(value,defaultValue);
    }
    public Time getDefaultTimeIfNull(Time value) {return getDefaultTime(value,TIME);
    }

    public boolean isBetween(Date date, Date init, Date end) {
        return (date.after(init) && date.before(end));
    }

    public boolean isBetweenIncludingInit(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(init));
    }

    public boolean isBetweenIncludingEnd(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(end));
    }

    public boolean isBetweenIncludingRanges(Date date, Date init, Date end) {
        return (isBetweenIncludingEnd(date, init, end) || isBetweenIncludingInit(date, init, end));
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }

    public Date getLocalDateADate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public LocalDate getDateALocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public boolean isOfLegalAge(Date birthDate) {
        Period period = Period.between(getDateALocalDate(birthDate), currentDate());
        return !UtilNumeric.getUtilNumeric().isLessThan(period.getYears(), 18);
    }

}
