package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class Stockincreased extends AbstractEvent {

    private Long id;
    private String stock;
    private String productid;
    private String productname;

    public Stockincreased(Inventory aggregate) {
        super(aggregate);
    }

    public Stockincreased() {
        super();
    }
}
