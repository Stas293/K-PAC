package org.spring.app.dao.impl;

import org.spring.app.dao.KnowledgePackageSetDao;
import org.spring.app.model.KnowledgePackageSet;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    private static final String INSERT = "insert into knowledge_package_set (title) values (?)";
    private static final String INSERT_RELATION = "insert into knowledge_package_has_knowledge_package_set " +
            "(knowledge_package_set_id, knowledge_package_id) " +
            "values (?, ?)";
    private static final String FIND_ALL = "select * from knowledge_package_set";
    private static final String FIND_BY_ID = "select * from knowledge_package_set where id = ?";
    private static final String DELETE = "delete from knowledge_package_set where id = ?";
    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Long save(KnowledgePackageSet knowledgePackageSet) {
        jdbcTemplate.update(
                INSERT,
                knowledgePackageSet.getTitle()
        );
        return jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
    }

    @Override
    public void saveBatchRelation(KnowledgePackageSet knowledgePackageSet) {
        jdbcTemplate.batchUpdate(
                INSERT_RELATION,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, knowledgePackageSet.getId());
                        ps.setLong(2, knowledgePackageSet.getKnowledgePackages().get(i).getId());
                    }

                    @Override
                    public int getBatchSize() {
                        return knowledgePackageSet.getKnowledgePackages().size();
                    }
                }
        );
    }

    @Override
    public List<KnowledgePackageSet> findAll() {
        return jdbcTemplate.query(
                FIND_ALL,
                new BeanPropertyRowMapper<>(KnowledgePackageSet.class));
    }

    @Override
    public KnowledgePackageSet findById(Long id) {
        return jdbcTemplate.query(
                        FIND_BY_ID,
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(KnowledgePackageSet.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
