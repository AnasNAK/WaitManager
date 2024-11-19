package org.NAK.WaitManager.Util;

import org.NAK.WaitManager.Entity.Visit;

import java.util.Comparator;
import java.util.List;

public class Algorithm {


    public static List<Visit> schedule(List<Visit> visits, String algorithm) {
        switch (algorithm.toUpperCase()) {
            case "FIFO":
                return fifo(visits);
            case "PRIORITY":
                return priority(visits);
            case "SJF":
                return sjf(visits);
            default:
                throw new IllegalArgumentException("Unsupported scheduling algorithm: " + algorithm);
        }
    }


    private static List<Visit> fifo(List<Visit> visits) {
        visits.sort(Comparator.comparing(Visit::getArrivalTime));
        return visits;
    }


    private static List<Visit> priority(List<Visit> visits) {
        visits.sort(Comparator.comparingInt(Visit::getPriority)
                .thenComparing(Visit::getArrivalTime));
        return visits;
    }


    private static List<Visit> sjf(List<Visit> visits) {
        visits.sort(Comparator.comparingInt(Visit::getEstimatedProcessTime)
                .thenComparing(Visit::getArrivalTime));
        return visits;
    }
}
