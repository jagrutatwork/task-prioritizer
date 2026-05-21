package com.jagrut.taskprioritizer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private String description;
    private Integer priority;
    private TicketStatus status;
    private LocalDateTime createdAt;

}
