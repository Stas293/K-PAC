package org.spring.app.service.impl;

import org.spring.app.dao.KnowledgePackageDao;
import org.spring.app.dao.KnowledgePackageSetDao;
import org.spring.app.model.KnowledgePackage;
import org.spring.app.model.KnowledgePackageSet;
import org.spring.app.service.KnowledgePackageSetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackageSetDao,
                                          KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageSetDao = knowledgePackageSetDao;
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(KnowledgePackageSet knowledgePackageSet) {
        Long id = knowledgePackageSetDao.save(knowledgePackageSet);
        knowledgePackageSet.setId(id);
        knowledgePackageSetDao.saveBatchRelation(knowledgePackageSet);
    }

    @Override
    public List<KnowledgePackageSet> findAll() {
        return knowledgePackageSetDao.findAll();
    }

    @Override
    public KnowledgePackageSet findById(Long id) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetDao.findById(id);
        if (knowledgePackageSet == null) {
            return KnowledgePackageSet.builder()
                    .knowledgePackages(List.of())
                    .build();
        }
        List<KnowledgePackage> knowledgePackages = knowledgePackageDao.findAllByKnowledgePackageSetId(id);
        knowledgePackageSet.setKnowledgePackages(knowledgePackages);
        return knowledgePackageSet;
    }

    @Override
    public void deleteById(Long id) {
        knowledgePackageSetDao.delete(id);
    }
}
