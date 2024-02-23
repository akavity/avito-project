package org.akavity.models.realEstateTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentData {
    String section;
    String typeRealEstate;
    String intention;
    String deskTopRooms;
    String numberOfRooms;
    String limitOfPrice;
    String minPrice;
    String maxPrice;
    String partOftTitle;
}
