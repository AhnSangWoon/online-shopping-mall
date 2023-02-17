package WebCapstone.WebCapstone.Upload;


import WebCapstone.WebCapstone.DTO.SignupDTO;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadDTO;
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
public class Upload {
    private String MemberId;
    private Category category;
    private String itemName;
    private String title;//게시글 제목
    private String main_text;//게시글 본문
    private int itemPrice;

    public Upload(UploadDTO dto){
        this.MemberId = dto.getMemberId();
        this.category = dto.getCategory();
        this.itemName = dto.getItemName();
        this.title = dto.getTitle();
        this.main_text = dto.getMain_text();
        this.itemPrice = dto.getItemPrice();

    }

}
