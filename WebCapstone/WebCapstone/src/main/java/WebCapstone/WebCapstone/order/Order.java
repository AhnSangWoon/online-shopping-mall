package WebCapstone.WebCapstone.order;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Order")
@Table(name ="Order")
public class Order {

    private String MemberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    private Category category;
}
