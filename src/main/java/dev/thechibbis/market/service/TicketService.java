package dev.thechibbis.market.service;

import dev.thechibbis.market.domain.model.Ticket;
import dev.thechibbis.market.domain.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> listAll() {
        return ticketRepository.findAll();
    }

    @Transactional
    public void create(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }
}
