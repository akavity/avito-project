package org.akavity.models.realEstateTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentFilterData {
    String section;
    String numberOfRoomsTitle;
    String numberOfRooms;
    String limitOfPrice;
    String minPrice;
    String maxPrice;
    String limitOfArea;
    String minArea;
    String maxArea;
    String repairTitle;
    String repair;
    String bathroomTypeTitle;
    String bathroomType;
    String houseTypeTitle;
    String houseType;
    String partOfName;
}
