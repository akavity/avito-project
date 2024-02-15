package org.akavity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomData {
    String section;
    String deskTopApartment;
    String dropDownRoom;
    String checkboxRooms;
    String numberOfRooms;
    String limitOfArea;
    String minArea;
    String maxArea;
    String limitOfPrice;
    String minPrice;
    String maxPrice;
}
