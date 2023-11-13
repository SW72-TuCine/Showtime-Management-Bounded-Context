package com.upc.ShowTimeBD.Shared;

import lombok.Data;

@Data
public class TicketResponse {
    long id;
    int status;
    int total_price;
}
