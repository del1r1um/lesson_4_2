package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int ticketPrice;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTimeInMinutes;

    @Override
    public int compareTo(TicketOffer o) {
        return ticketPrice - o.ticketPrice;
    }
}
