/*
package WebCapstone.WebCapstone.repository;

import WebCapstone.WebCapstone.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaRepository implements MemberRepository{

    private final EntityManager em;

    public JpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<MemberEntity> findById(String s) {
        MemberEntity member = em.find(MemberEntity.class, s);
        return Optional.ofNullable(member);
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
        em.persist(memberEntity);
        return memberEntity;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends MemberEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends MemberEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<MemberEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MemberEntity getOne(String s) {
        return null;
    }

    @Override
    public MemberEntity getById(String s) {
        return null;
    }

    @Override
    public MemberEntity getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends MemberEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MemberEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends MemberEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends MemberEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MemberEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MemberEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends MemberEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends MemberEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<MemberEntity> findAll() {
        return null;
    }

    @Override
    public List<MemberEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(MemberEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends MemberEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<MemberEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MemberEntity> findAll(Pageable pageable) {
        return null;
    }
}
*/
