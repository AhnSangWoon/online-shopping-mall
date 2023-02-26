package WebCapstone.WebCapstone.service;

import WebCapstone.WebCapstone.DTO.ResponseDTO;
import WebCapstone.WebCapstone.DTO.SignInDTO;
import WebCapstone.WebCapstone.DTO.SignInResponseDTO;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadResponseDTO;
import WebCapstone.WebCapstone.Upload.Upload;
import WebCapstone.WebCapstone.entity.MemberEntity;
import WebCapstone.WebCapstone.repository.UploadRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//서버에 올린거 메인화면에 보여지게 만들어주는 서비스

@Service
public class ShowUploadService {
    @Autowired
    UploadRepository uploadRepository;


    public ResponseDTO<UploadResponseDTO> ShowUpload(){
        List<Upload> uploadArray = null;
        try{
            uploadArray = uploadRepository.findAll();
            //잘못된 아이디
            if(uploadArray == null) {
                System.out.println("내역없음");
                UploadResponseDTO uploadResponseDTO = new UploadResponseDTO(null);
                return ResponseDTO.setSuccess("아직 업로드된 글 없음", uploadResponseDTO);
            }
        }catch(Exception e){
            return ResponseDTO.setFailed("데이터베이스 에러");
        }

        UploadResponseDTO uploadResponseDTO = new UploadResponseDTO(uploadArray);
        System.out.println(uploadArray.toString());
        return ResponseDTO.setSuccess("메인 화면에 글 전송 완료", uploadResponseDTO);
    }
}
