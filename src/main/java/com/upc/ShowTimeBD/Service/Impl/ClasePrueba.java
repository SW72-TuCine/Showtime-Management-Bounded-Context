package com.upc.ShowTimeBD.Service.Impl;

import com.upc.ShowTimeBD.Client.CinemaClient;
import com.upc.ShowTimeBD.Shared.CinemaResponse;
import feign.FeignException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClasePrueba {

    @Autowired
    CinemaClient cinemaClient;

    public void getCinemaInformationById(String id){
        try{
            ResponseEntity<CinemaResponse> CineClubResponse = cinemaClient.getCineclubById(Long.valueOf(id));
            System.out.println(CineClubResponse.getBody().getCapacity());
        } catch (FeignException feignException) {
            throw new ValidationException(feignException.getMessage());
        }
    }
}
