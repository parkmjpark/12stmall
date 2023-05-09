package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Search_table")
@Data
public class Search {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
