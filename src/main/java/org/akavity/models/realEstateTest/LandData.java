package org.akavity.models.realEstateTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandData {
    String section;
    String deskTopApartment;
    String dropDownApartment;
    String deskTopLandType;
    String checkboxLandType;
    String deskTopSlider;
    int leftHandleOffset;
    int rightHandleOffset;
    String limitOfPrice;
    String minPrice;
    String maxPrice;
}
