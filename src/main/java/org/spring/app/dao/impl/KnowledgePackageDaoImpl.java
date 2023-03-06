package org.spring.app.dao.impl;

import org.spring.app.dao.KnowledgePackageDao;
import org.spring.app.model.KnowledgePackage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {
    private static final String FIND_ALL = "select * from knowledge_package";
    private static final String FIND_BY_ID = "select * from knowledge_package where id = ?";
    private static final String INSERT = "insert into knowledge_package (title, description, creation) values (?, ?, ?)";
    private static final String DELETE = "delete from knowledge_package where id = ?";
    private static final String FIND_ALL_BY_KNOWLEDGE_PACKAGE_SET_ID = "select * from knowledge_package " +
            "join knowledge_package_has_knowledge_package_set " +
            "on knowledge_package.id = knowledge_package_has_knowledge_package_set.knowledge_package_id " +
            "where knowledge_package_has_knowledge_package_set.knowledge_package_set_id = ?";

    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KnowledgePackage> findAll() {
        return jdbcTemplate.query(
                FIND_ALL,
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    @Override
    public KnowledgePackage findById(Long id) {
        return jdbcTemplate.query(
                        FIND_BY_ID,
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(KnowledgePackage.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public Long save(KnowledgePackage knowledgePackage) {
        jdbcTemplate.update(INSERT,
                knowledgePackage.getTitle(),
                knowledgePackage.getDescription(),
                knowledgePackage.getCreation());
        return jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<KnowledgePackage> findAllByKnowledgePackageSetId(Long id) {
        return jdbcTemplate.query(
                FIND_ALL_BY_KNOWLEDGE_PACKAGE_SET_ID,
                new Object[]{id},
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    @Override
    public List<KnowledgePackage> findAllByIds(List<Long> knowledgePackages) {
        return jdbcTemplate.query(
                "select * from knowledge_package where id in (" +
                        Stream.generate(() -> "?")
                                .limit(knowledgePackages.size())
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("") + ")",
                knowledgePackages.toArray(),
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }
}
