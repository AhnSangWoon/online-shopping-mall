package WebCapstone.WebCapstone.DTO.Upload_Order;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UploadDTO {
    private String memberid;

    @NotEmpty(message = "카테고리를 선택해주세요")
    private String category;
    @NotEmpty(message = "세부 카테고리를 선택해주세요")
    private String detailcategory;
    @NotEmpty(message = "아이템 이름을 입력해주세요")
    private String itemname;
    private int itemid;

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;//게시글 제목
    @NotEmpty(message = "본문을 작성해주세요")
    private String maintext;//게시글 본문
    @NotEmpty(message = "아이템 가격을 입력해주세요")
    private int itemprice;

    private String URL;

    private int view;


    private int favor;

    private String uploadtime;
    private String purpose;



    private boolean favorcheck = false;



    @Builder
    public UploadDTO(String memberid, String category, String detailcategory, String itemname, int itemid, String title, String maintext, int itemprice, String purpose,String URL, int view, int favor, String uploadtime, boolean favorcheck){
        this.memberid = memberid;
        this.category = category;
        this.detailcategory = detailcategory;
        this.itemname = itemname;
        this.itemid = itemid;
        this.title = title;
        this.maintext = maintext;
        this.itemprice = itemprice;
        this.URL = URL;
        this.view = view;
        this.favor = favor;
        this.uploadtime = uploadtime;
        this.purpose = purpose;
        this.favorcheck = favorcheck;

    }


}