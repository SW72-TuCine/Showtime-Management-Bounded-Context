package com.upc.ShowTimeBD.Service.Impl;

import com.upc.ShowTimeBD.Client.CinemaClient;
import com.upc.ShowTimeBD.Client.MovieClient;
import com.upc.ShowTimeBD.Models.ShowTimeModel;
import com.upc.ShowTimeBD.Repositories.ShowTimeRepository;
import com.upc.ShowTimeBD.Service.ShowTimeService;
import com.upc.ShowTimeBD.Shared.CinemaResponse;
import com.upc.ShowTimeBD.Shared.FilmResponse;
import feign.FeignException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {
    private final ShowTimeRepository showTimeRepository;

    @Autowired
    private CinemaClient cinemaClient;
    @Autowired
    private MovieClient movieClient;

    @Override
    @Transactional
    public ShowTimeModel save(ShowTimeModel showTimeModel) throws Exception {
        String id = showTimeModel.getCinemaId().toString();
        ValidateIfCinemaExists(id);
        ValidateIfMovieExist(showTimeModel.getMovieId().toString());
        return showTimeRepository.save(showTimeModel);
    }
    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        showTimeRepository.deleteById(id);
    }
    @Override
    @Transactional
    public List<ShowTimeModel> getAll() throws Exception {
        return showTimeRepository.findAll();
    }
    @Override
    @Transactional
    public Optional<ShowTimeModel> getById(Long id) throws Exception {
        return showTimeRepository.findById(id);
    }


    private void ValidateIfMovieExist(String id) throws Exception{
        try{
            ResponseEntity<FilmResponse> FilmbResponse = movieClient.getMovieById(Long.valueOf(id));
            if(FilmbResponse.getBody().getId() == null){
                throw new ValidationException("Film does not exist");
            }

        } catch (FeignException feignException) {
            throw new ValidationException(feignException.getMessage());
        }
    }
    private void ValidateIfCinemaExists(String id) throws Exception {
        try{
            ResponseEntity<CinemaResponse> CineClubResponse = cinemaClient.getCinemaByName(Long.valueOf(id));
            if(CineClubResponse.getBody().getId() == null){
                throw new ValidationException("Cinema does not exist");
            }

        } catch (FeignException feignException) {
            throw new ValidationException(feignException.getMessage());
        }
    }
/*
    @Override
    public int updateCapacity(Long id, int capacity) throws Exception {
        return showTimeRepository.updateCapacity(id,capacity);
    }

 */
}
