package com.upc.showTime.Service.Impl;

import com.upc.showTime.Models.ShowTimeModel;
import com.upc.showTime.Repositories.ShowTimeRepository;
import com.upc.showTime.Service.ShowTimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {
    private final ShowTimeRepository showTimeRepository;


    public ShowTimeServiceImpl(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    @Override
    @Transactional
    public ShowTimeModel save(ShowTimeModel showTimeModel) throws Exception {
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


    @Override
    public int UpdateCapacity(Long id, int capacity) throws Exception {
        return showTimeRepository.UpdateCapacity(id,capacity);
    }
}
