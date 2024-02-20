package org.akavity.models.autoTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarFilterTwoData {
    String sectionFirst;
    String sectionSecond;
    String priceTitle;
    String minPrice;
    String maxPrice;
    String yearOfIssueTitle;
    String minYearOfIssue;
    String maxYearOfIssue;
    String carMileageTitle;
    String maxCarMileage;
    String driveUnitTitle;
    String driveUnit;
    String engineTypeTitle;
    String engineType;
    String carConditionTitle;
    String carCondition;
    String bodyStyleTitle;
    String bodyStyle;
    List<String> parameters;
    int numberOfArrayElements;
}
