package co.edu.uco.crosscutting.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class UtilDate {

    private static final DateTimeFormatter timeAndDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static final LocalDateTime TIME = LocalDateTime.now();

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

    public LocalDateTime getDefaultTime(LocalDateTime value, LocalDateTime defaultValue) {
        return getUtilObject().getDefaultIsNull(value,defaultValue);
    }
    public LocalDateTime getDefaultTimeIfNull(LocalDateTime value) {
        return getDefaultTime(value,TIME);
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

    public Date getLocalDataTimeADate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime getDateALocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public boolean isOfLegalAge(Date birthDate) {
        Period period = Period.between(getDateALocalDate(birthDate), currentDate());
        return !UtilNumeric.getUtilNumeric().isLessThan(period.getYears(), 18);
    }

}
