package org.spring.app.service.impl;

import org.spring.app.dao.KnowledgePackageDao;
import org.spring.app.model.KnowledgePackage;
import org.spring.app.service.KnowledgePackageService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public List<KnowledgePackage> findAll() {
        return knowledgePackageDao.findAll();
    }

    @Override
    public void save(KnowledgePackage knowledgePackage) {
        knowledgePackage.setCreation(LocalDate.now());
        knowledgePackageDao.save(knowledgePackage);
    }

    @Override
    public void deleteById(Long id) {
        knowledgePackageDao.delete(id);
    }

    @Override
    public List<KnowledgePackage> findAllById(List<Long> knowledgePackages) {
        return knowledgePackageDao.findAllByIds(knowledgePackages);
    }
}
