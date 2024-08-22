package com.tambola.model;

import java.util.*;

public class Ticket {
    private final List<Set<Integer>> ticketNumbers;

    public Ticket(List<List<Integer>> numbers) {
        this.ticketNumbers = new ArrayList<>();
        numbers.forEach(row -> {
            Set<Integer> rowSet = new HashSet<>(row);
            this.ticketNumbers.add(rowSet);
        });
    }

    public List<Set<Integer>> getTicketNumbers() {
        List<Set<Integer>> fetchNumbers = new ArrayList<>();
        this.ticketNumbers.forEach(row -> {
            Set<Integer> rowSet = new HashSet<>(row);
            fetchNumbers.add(rowSet);
        });
        return fetchNumbers;
    }
}
