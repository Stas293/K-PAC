package org.spring.app.dao;

import org.spring.app.model.KnowledgePackageSet;

public interface KnowledgePackageSetDao extends GenericDao<KnowledgePackageSet> {
    void saveBatchRelation(KnowledgePackageSet knowledgePackageSet);
}
