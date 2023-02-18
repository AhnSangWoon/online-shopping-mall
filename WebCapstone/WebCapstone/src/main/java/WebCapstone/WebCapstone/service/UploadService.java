package WebCapstone.WebCapstone.service;

import WebCapstone.WebCapstone.DTO.ResponseDTO;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadDTO;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadResponseDTO;
import WebCapstone.WebCapstone.Upload.Category;
import WebCapstone.WebCapstone.Upload.Upload;
import WebCapstone.WebCapstone.entity.MemberEntity;
import WebCapstone.WebCapstone.repository.MemberRepository;
import WebCapstone.WebCapstone.repository.UploadRepository;
import WebCapstone.WebCapstone.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

    @Autowired
    UploadRepository uploadRepository;

    @Autowired
    TokenProvider tokenProvider;

    public ResponseDTO<UploadResponseDTO> Upload(UploadDTO dto){
        String memberId = dto.getMemberId();
        Category category = dto.getCategory();
        String itemName = dto.getItemName();
        String main_text = dto.getMain_text();
        String title = dto.getTitle();
        int itemPrice = dto.getItemPrice();

        try{
            if(category.equals("clothes")==false && category.equals("job")==false){
                return ResponseDTO.setFailed("카테고리는 clothes, job중 하나를 선택해주세요");
            }
            if(memberId.equals(null)==true){
                return ResponseDTO.setFailed("아이디 값이 필요합니다.");
            }
            if(itemName.equals(null)==true){
                return ResponseDTO.setFailed("상품의 이름을 입력해주세요");
            }
            if(itemName.equals(null)==true){
                return ResponseDTO.setFailed("상품의 이름을 입력해주세요");
            }
        }catch(Exception e){
            return ResponseDTO.setFailed("서버 오류입니다.");
        }

        if(title.equals(null)==true){
            dto.setTitle("제목없음");
        }
        if(main_text.equals(null)==true){
            dto.setMain_text(" ");
        }

        Upload upload = new Upload(dto);
        System.out.println("ok");

        //비밀번호 암호화
        try{
            uploadRepository.save(upload);
        }catch(Exception e){
            return ResponseDTO.setFailed("Data Base error");
        }




        return ResponseDTO.setSuccess("상품이 업로드 되었습니다.", null);
    }
}
