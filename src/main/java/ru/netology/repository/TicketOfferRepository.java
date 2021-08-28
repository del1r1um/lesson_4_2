package ru.netology.repository;

import ru.netology.domain.TicketOffer;

public class TicketOfferRepository {
    private TicketOffer[] ticket = new TicketOffer[0];

    public void save(TicketOffer ticket) {
        int length = this.ticket.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(this.ticket, 0, tmp, 0, this.ticket.length);
        tmp[tmp.length - 1] = ticket;
        this.ticket = tmp;
    }

    public TicketOffer[] getAll() {
        return ticket;
    }
}