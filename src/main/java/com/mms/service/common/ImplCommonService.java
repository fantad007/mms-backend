package com.mms.service.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class ImplCommonService implements CommonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long createId(String table) {
        String jpql = "SELECT MAX(e.id) FROM " + table + " e WHERE e.isDeleted = false";
        Query query = entityManager.createQuery(jpql);
        Long max = (Long) query.getSingleResult();
        if (max == null) {
            return 1L;
        } else {
            return max + 1;
        }
    }
}
