package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String code;
    private String des;
    private Double unitPrice;
    private int qtyOnHand;
}
