package WebCapstone.WebCapstone.repository;

import WebCapstone.WebCapstone.DTO.SignupDTO;
import WebCapstone.WebCapstone.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findById(String s);

    MemberEntity save(MemberEntity memberEntity);
}
