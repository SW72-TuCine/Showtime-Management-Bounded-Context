package com.upc.ShowTimeBD.Client;

import com.upc.ShowTimeBD.Shared.CinemaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cineclub-administration-service",path = "/api/TuCine/v1/cineclub_administration")
public interface CinemaClient {

    @RequestMapping("/cineclubs/verify/{cineclubId}")
    boolean checkIfCinemaExist(@PathVariable("cineclubId") Long cineclubId) throws RuntimeException;

    @GetMapping("/cineclubs/{cineclubId}")
    public ResponseEntity<CinemaResponse> getCinemaByName(@PathVariable("cineclubId") Long id);


}
