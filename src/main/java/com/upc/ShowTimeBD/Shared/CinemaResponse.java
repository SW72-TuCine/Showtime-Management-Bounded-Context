package com.upc.ShowTimeBD.Shared;

import lombok.Data;

@Data
public class CinemaResponse {
    Long id;
    Long ownerId;
    String name;
    String description;
    TypeCinema typeCinema;

}
