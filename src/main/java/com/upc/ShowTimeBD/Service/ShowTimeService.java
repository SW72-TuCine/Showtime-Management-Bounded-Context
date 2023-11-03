package com.upc.ShowTimeBD.Service;

import com.upc.ShowTimeBD.Models.ShowTimeModel;

public interface ShowTimeService extends CrudService<ShowTimeModel>{
    void ValidateIfCinemaExists(String id) throws Exception;
    //int updateCapacity(Long id, int capacity) throws Exception;
}
