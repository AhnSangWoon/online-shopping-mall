package WebCapstone.WebCapstone.service;


import WebCapstone.WebCapstone.DTO.ForumDTO;
import WebCapstone.WebCapstone.DTO.ResponseDTO;
import WebCapstone.WebCapstone.DTO.SignupDTO;
import WebCapstone.WebCapstone.entity.ForumEntity;
import WebCapstone.WebCapstone.entity.MemberEntity;
import WebCapstone.WebCapstone.repository.ForumRepository;
import ch.qos.logback.core.pattern.FormatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumService {

    @Autowired
    ForumRepository forumRepository;

    public ResponseDTO<?> Store(ForumDTO dto){
        int star = dto.getStar();
        String comment = dto.getComment();
        int commentid = dto.getCommentid();
        int itemid = dto.getItemid();

        try{
            while(forumRepository.findByCommentid(commentid)!=null){
                commentid++;
            }
            dto.setItemid(itemid);
            //upload = uploadRepository.findByid(itemid);

        }catch(Exception e){
            return ResponseDTO.setFailed("입려하신 리뷰의 고유코드에 문제가 생겼습니다.");
        }

        ForumEntity forumEntity = new ForumEntity(dto);

        try{
            forumRepository.save(forumEntity);
        }catch(Exception e){
            return ResponseDTO.setFailed("Data Base error");
        }

        return ResponseDTO.setSuccess("comment upload success", null);
    }
}
