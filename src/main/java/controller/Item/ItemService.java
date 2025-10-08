package controller.Item;

import model.Customer;
import model.Item;

import java.util.List;

public interface ItemService {
    boolean addItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(String item);
    Item getItem(String code);
    List<Item> getDetails();


}
