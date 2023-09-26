package com.upc.showTime.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "showTime")
public class ShowTimeModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP) // Puedes usar TemporalType.DATE si solo necesitas la fecha sin hora
    @Column(name = "date", nullable = false)
    private Date functionDate;
    @Column(name = "movieId", nullable = false)
    private Long movieId;
    @Column(name = "cinemaId", nullable = false)
    private Long cinemaId;
    @Column(name="numberofseats", nullable = false)
    private int numberOfSeats;
    @Column(name="capacity", nullable = false)
    private int capacity;
    @Column(name="notes", nullable = false)
    private String notes;
    @Temporal(TemporalType.TIMESTAMP) // Puedes usar TemporalType.DATE si solo necesitas la fecha sin hora
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP) // Puedes usar TemporalType.DATE si solo necesitas la fecha sin hora
    @Column(name = "lastModifyDate", nullable = false)
    private Date lastModifyDate;

}
