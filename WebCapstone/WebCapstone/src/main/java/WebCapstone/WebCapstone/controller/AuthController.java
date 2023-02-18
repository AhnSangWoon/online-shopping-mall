package WebCapstone.WebCapstone.controller;

import WebCapstone.WebCapstone.DTO.*;
//import WebCapstone.WebCapstone.service.AuthService;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadDTO;
import WebCapstone.WebCapstone.DTO.Upload_Order.UploadResponseDTO;
import WebCapstone.WebCapstone.service.AuthService;
import WebCapstone.WebCapstone.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    UploadService uploadService;

    @PostMapping("/signUp") // 회원가입 기능(추후에 구현)
    public ResponseDTO<?> signUp(@RequestBody SignupDTO requestBody){
        System.out.println(requestBody.toString());
        ResponseDTO<?> result = authService.signUp(requestBody);
        return result;

    }

    @PostMapping("/signIn") // 로그인 기능(추후에 구현)
    public ResponseDTO<SignInResponseDTO> signIn(@RequestBody SignInDTO requestBody){
        System.out.println(requestBody.toString());
        ResponseDTO<SignInResponseDTO> result = authService.signIn(requestBody);
        return result;

    }

    @PostMapping("/Upload") // 업로드 기능
    public ResponseDTO<UploadResponseDTO> Upload(@RequestBody UploadDTO requestBody){
        System.out.println(requestBody.toString());
        ResponseDTO<UploadResponseDTO> result = uploadService.Upload(requestBody);
        return result;

    }


}
