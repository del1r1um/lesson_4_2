package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOfferManager {
    private TicketOfferRepository ticketOfferRepository;

    public void add(TicketOffer ticket) {
        ticketOfferRepository.save(ticket);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : ticketOfferRepository.getAll()) {
            int length = result.length;
            if (ticket.getDepartureAirport().contains(from) && ticket.getArrivalAirport().contains(to)) {
                TicketOffer[] tmp = new TicketOffer[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
