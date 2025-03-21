package dev.thechibbis.market.presentation;

import dev.thechibbis.market.domain.model.Ticket;
import dev.thechibbis.market.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> ListAll() {
        return ticketService.listAll();
    }

    @PostMapping("/new")
    public Ticket Create(@RequestBody Ticket ticket) {
        ticketService.create(ticket);
        return ticket;
    }
}
