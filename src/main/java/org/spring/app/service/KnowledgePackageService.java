package org.spring.app.service;

import org.spring.app.model.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageService {
    List<KnowledgePackage> findAll();

    void save(KnowledgePackage knowledgePackage);

    void deleteById(Long id);

    List<KnowledgePackage> findAllById(List<Long> knowledgePackages);
}
