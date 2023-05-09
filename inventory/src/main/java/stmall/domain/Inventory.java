package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.InventoryApplication;
import stmall.domain.StockDecreased;
import stmall.domain.Stockincreased;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String stock;

    private String productid;

    private String productname;

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        Stockincreased stockincreased = new Stockincreased(this);
        stockincreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void stockdecrease(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        StockDecreased stockDecreased = new StockDecreased(inventory);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            StockDecreased stockDecreased = new StockDecreased(inventory);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    public static void stockincrease(DeliveryCancled deliveryCancled) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        Stockincreased stockincreased = new Stockincreased(inventory);
        stockincreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            Stockincreased stockincreased = new Stockincreased(inventory);
            stockincreased.publishAfterCommit();

         });
        */

    }
}
