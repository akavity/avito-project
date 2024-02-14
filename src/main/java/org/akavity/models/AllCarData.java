package org.akavity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCarData {
    String section;
    String carBrand;
    String carModel;
    String fullCarName;
    int numberOfArrayElements;
}
