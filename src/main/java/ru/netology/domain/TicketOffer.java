package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparator<TicketOffer> {
    private int id;
    private int ticketPrice;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTimeInMinutes;

    @Override
    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getFlightTimeInMinutes() - o2.getFlightTimeInMinutes();
    }
}
