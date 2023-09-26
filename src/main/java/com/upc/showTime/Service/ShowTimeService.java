package com.upc.showTime.Service;

import com.upc.showTime.Models.ShowTimeModel;

public interface ShowTimeService extends CrudService<ShowTimeModel>{
    int UpdateCapacity(Long id, int capacity) throws Exception;
}
