package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferManagerTest {
    private TicketOfferRepository ticketOfferRepository = new TicketOfferRepository();
    private TicketOfferManager manager = new TicketOfferManager(ticketOfferRepository);

    private TicketOffer ticket1 = new TicketOffer(1, 10_000, "MOW", "ZNZ", 720);
    private TicketOffer ticket2 = new TicketOffer(2, 15_000, "ZNZ", "MOW", 740);
    private TicketOffer ticket3 = new TicketOffer(3, 20_000, "MOW", "KGS", 300);
    private TicketOffer ticket4 = new TicketOffer(4, 20_000, "MOW", "KGS", 240);

    @BeforeEach
    void SetUp() {
        ticketOfferRepository.save(ticket1);
        ticketOfferRepository.save(ticket2);
        ticketOfferRepository.save(ticket3);
        ticketOfferRepository.save(ticket4);
    }

    @Test
    @DisplayName("Sort by fastest route")
    void shouldSortByFastestRoute() {
        TicketOffer[] actual = manager.findAll("MOW", "KGS", new TicketOffer());
        TicketOffer[] expected = {ticket4, ticket3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Sort if route not exist")
    void shouldSortByNotExistRoute() {
        TicketOffer[] actual = manager.findAll("KGS", "ZNZ", new TicketOffer());
        TicketOffer[] expected = {};
        assertArrayEquals(expected, actual);
    }
}