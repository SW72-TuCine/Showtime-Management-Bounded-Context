package com.upc.showTime.Repositories;

import com.upc.showTime.Models.ShowTimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTimeModel, Long> {
    int UpdateCapacity(Long id, int capacity) throws Exception;

}
