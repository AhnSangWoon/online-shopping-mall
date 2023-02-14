package WebCapstone.WebCapstone.repository;

import WebCapstone.WebCapstone.entity.MemberEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JdbcRepository implements MemberRepository{

    private final DataSource dataSource;
    public JdbcRepository(DataSource dataSource){ this.dataSource = dataSource;}

    @Override
    public Optional<MemberEntity> findById(String s) {
        String sql = "select * from member where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                MemberEntity memberEntity = new MemberEntity();
                memberEntity.setId(rs.getString("id"));
                memberEntity.setNickname(rs.getString("name"));
                return Optional.of(memberEntity);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
        String sql = "insert into member(name) values(?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, memberEntity.getNickname());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                memberEntity.setId(rs.getString(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return memberEntity;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
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
