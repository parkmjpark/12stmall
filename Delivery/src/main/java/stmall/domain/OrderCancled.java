package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String productname;
    private Long productid;
    private Long userid;
    private Integer qty;
}
