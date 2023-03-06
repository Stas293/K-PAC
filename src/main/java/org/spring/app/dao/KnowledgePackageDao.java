package org.spring.app.dao;

import org.spring.app.model.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageDao extends GenericDao<KnowledgePackage> {

    List<KnowledgePackage> findAllByKnowledgePackageSetId(Long id);

    List<KnowledgePackage> findAllByIds(List<Long> knowledgePackages);
}
