package dev.thechibbis.market.domain.repository;

import dev.thechibbis.market.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
