package WebCapstone.WebCapstone.repository;

import WebCapstone.WebCapstone.entity.ForumEntity;
import WebCapstone.WebCapstone.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<ForumEntity, String> {

    public ForumEntity findByCommentid(int commentid);



}
