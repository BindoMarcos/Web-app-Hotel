package com.hotelmvc.front.models.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private int n_room;
    private int q_beds;
    private boolean busy = true;

}
