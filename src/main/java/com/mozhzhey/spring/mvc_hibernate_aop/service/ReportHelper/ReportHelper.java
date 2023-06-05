package com.mozhzhey.spring.mvc_hibernate_aop.service.ReportHelper;

public class ReportHelper {
    int amountOfRoutes;

    int amountOfDaysAll;

    int amountOfDaysLastMonth;

    public ReportHelper(int amountOfRoutes, int amountOfDaysAll, int amountOfDaysLastMonth) {
        this.amountOfRoutes = amountOfRoutes;
        this.amountOfDaysAll = amountOfDaysAll;
        this.amountOfDaysLastMonth = amountOfDaysLastMonth;
    }

    public int getAmountOfRoutes() {
        return amountOfRoutes;
    }

    public void setAmountOfRoutes(int amountOfRoutes) {
        this.amountOfRoutes = amountOfRoutes;
    }

    public int getAmountOfDaysAll() {
        return amountOfDaysAll;
    }

    public void setAmountOfDaysAll(int amountOfDaysAll) {
        this.amountOfDaysAll = amountOfDaysAll;
    }

    public int getAmountOfDaysLastMonth() {
        return amountOfDaysLastMonth;
    }

    public void setAmountOfDaysLastMonth(int amountOfDaysLastMonth) {
        this.amountOfDaysLastMonth = amountOfDaysLastMonth;
    }

    @Override
    public String toString() {
        return "ReportHelper{" +
                "amountOfRoutes=" + amountOfRoutes +
                ", amountOfDaysAll=" + amountOfDaysAll +
                ", amountOfDaysLastMonth=" + amountOfDaysLastMonth +
                '}';
    }

    public ReportHelper() {

    }
}
