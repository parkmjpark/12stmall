package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancled extends AbstractEvent {

    private Long id;
    private Long orderid;
    private Long productid;
    private String productname;
    private String address;
    private String status;
    private Integer qty;
}
