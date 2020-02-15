package Project019;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**You are given the following information, but you may prefer to
 * do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone,
 * Which has twenty-eight, rain or shine. And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth
 * century (1 Jan 1901 to 31 Dec 2000)?
 *
 * @author ndriqa
 */
public class CountingSundays {
    final int MONDAY = 0;
    final int TUESDAY = 1;
    final int WEDNESDAY = 2;
    final int THURSDAY = 3;
    final int FRIDAY = 4;
    final int SATURDAY = 5;
    final int SUNDAY = 6;

    final int JAN = 31;
    final int FEB = 28;
    final int MAR = 31;
    final int APR = 30;
    final int MAY = 31;
    final int JUN = 30;
    final int JUL = 31;
    final int AUG = 31;
    final int SEP = 30;
    final int OCT = 31;
    final int NOV = 30;
    final int DEC = 31;

    final int WEEK = 7;

    GregorianCalendar dateFrom;
    GregorianCalendar dateTo;

    int firstDayOfDateFrom;
    int countedSundays;

    public CountingSundays(GregorianCalendar from, GregorianCalendar to){
        dateFrom = from;
        dateTo = to;
        countedSundays = 0;
    }
    public void calculate(){
        GregorianCalendar beginning = new GregorianCalendar(1900, 1, 1);
        long diff19001901 = Math.abs(beginning.getTimeInMillis() - dateFrom.getTimeInMillis());
        int daysOf1900 = (int)(diff19001901/(1000*60*60*24));

        int firstDayOf1901 = daysOf1900 % WEEK;

        int day = firstDayOf1901;
        int year = 1901;

        while(year<2001){
            day = day % WEEK;
            if (day == SUNDAY){
                countedSundays++;
            }
            day += JAN%WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            if(isLeapYear(year)){
                day += (FEB + 1) % WEEK;
            } else {
                day += FEB % WEEK;
            }
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += MAR % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += APR % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += MAY % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += JUN % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += JUL % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += AUG % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += SEP % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += OCT % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += NOV % WEEK;
            day = day % WEEK;

            if (day == SUNDAY){
                countedSundays++;
            }
            day += DEC % WEEK;
            day = day % WEEK;

            year++;
        }
    }

    private boolean isLeapYear(int year) {
        boolean temp = false;
        if (year % 4 == 0 && year % 400 != 0) {
            temp = true;
        }
        return temp;
    }

    @Override
    public String toString(){
        return "there are " + countedSundays + " sundays as first days of months in 20th century" ;
    }

    public static void main(String[] args) {
        GregorianCalendar from = new GregorianCalendar(1901, 1, 1);
        GregorianCalendar to = new GregorianCalendar(2000, 12, 31);

        CountingSundays sun = new CountingSundays(from, to);
        sun.calculate();
        System.out.println(sun);
    }

}
