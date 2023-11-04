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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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
        ValidateIfCinemaExists(showTimeModel.getCinemaId().toString());
        //ValidateIfMovieExist(showTimeModel.getMovieId().toString());
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


    private void validateIfMovieExists(String id) throws ValidationException {
        try {
            ResponseEntity<FilmResponse> filmResponse = movieClient.getMovieById(Long.valueOf(id));

            if (filmResponse.getStatusCode() != HttpStatus.OK || filmResponse.getBody() == null) {
                throw new ValidationException("Film does not exist");
            }
        } catch (HttpServerErrorException ex) {
            throw new ValidationException("Error while checking film existence: " + ex.getMessage());
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ValidationException("Film does not exist");
            }
            throw new ValidationException("Error while checking film existence: " + ex.getMessage());
        } catch (Exception ex) {
            throw new ValidationException("An error occurred while checking film existence: " + ex.getMessage());
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
