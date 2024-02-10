package org.akavity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentData {
    String section;
    String typeRealEstate;
    String buyOrRent;
    String deskTopRooms;
    String numberOfRooms;
    String limitOfPrice;
    String minPrice;
    String maxPrice;
}
