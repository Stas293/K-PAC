package org.spring.app.service;

import org.spring.app.model.KnowledgePackageSet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KnowledgePackageSetService {
    @Transactional(rollbackFor = Exception.class)
    void save(KnowledgePackageSet knowledgePackageSet);

    List<KnowledgePackageSet> findAll();

    KnowledgePackageSet findById(Long id);

    void deleteById(Long id);
}
