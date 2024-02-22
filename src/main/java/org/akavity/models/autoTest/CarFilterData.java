package org.akavity.models.autoTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarFilterData {
    String sectionFirst;
    String sectionSecond;
    String typeCarTitle;
    String typeCar;
    String carBrandTitle;
    String carBrand;
    String carModelTitle;
    String carModel;
    String priceTitle;
    String minPrice;
    String maxPrice;
    String carMileageTitle;
    String minCarMileage;
    String maxCarMileage;
    String driveUnitTitle;
    String driveUnit;
    String fullCarName;
    int numberOfArrayElements;
}
