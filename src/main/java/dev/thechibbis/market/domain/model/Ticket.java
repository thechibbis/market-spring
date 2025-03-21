package dev.thechibbis.market.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

enum Category {
    BOSSFIGHTS,
    DINOS,
    SERVICES,
    BASEKITS,
    PVPKITS,
}

enum Order {
    BROODMOTHER,
    MEGAPITHECUS,
    DRAGON,

    ROCKWELL,
    MANTICORE,
    OVERSEER,

    RAID_SERVICE,
    BASE_KIT,
    PVP_KIT,

    DINOS
}

@Entity
@Getter @Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false, name = "ticket_order")
    @Enumerated(EnumType.STRING)
    private Order order;

    private String description;

    private Boolean paid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Users buyer;
}
