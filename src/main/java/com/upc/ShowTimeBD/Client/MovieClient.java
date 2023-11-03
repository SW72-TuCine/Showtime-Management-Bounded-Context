package com.upc.ShowTimeBD.Client;

import com.upc.ShowTimeBD.Shared.FilmResponse;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cineclub-administration-service",path = "/api/TuCine/v1/cineclub_administration")
public interface MovieClient {
    @RequestMapping("/films/verify/{filmName}")
    boolean checkIfMovieExist( @PathVariable("filmName") String  filmName) throws RuntimeException;

    @GetMapping("/films/search")
    public ResponseEntity<FilmResponse> getMovieById(@RequestParam("title") String title);

}