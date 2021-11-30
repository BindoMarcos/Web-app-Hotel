package com.hotel.api.repositories.Room;

import com.hotel.api.models.Room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepo extends CrudRepository<Room, Integer> {

    public Iterable<Room> findByBusy(boolean busy);

    @Query(value = "SELECT busy FROM rooms WHERE n_room = :nRoom ",nativeQuery = true)
    boolean isBusy(
        @Param("nRoom") int nRoom
    );
    
}
