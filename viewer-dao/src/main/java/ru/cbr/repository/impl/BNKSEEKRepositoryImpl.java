package ru.cbr.repository.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import ru.cbr.dto.BaseDto;
import ru.cbr.dto.BnkseekFilter;
import ru.cbr.model.BNKSEEK;
import ru.cbr.model.BNKSEEK_;
import ru.cbr.model.PZN_;
import ru.cbr.model.REG_;
import ru.cbr.repository.BNKSEEKRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BNKSEEKRepositoryImpl implements BNKSEEKRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BNKSEEK> getByParam(BnkseekFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BNKSEEK> criteriaQuery = cb.createQuery(BNKSEEK.class);
        Root<BNKSEEK> root = criteriaQuery.from(BNKSEEK.class);

        criteriaQuery.select(root);
        Predicate criteria = cb.conjunction();

        if (Objects.nonNull(filter.getBik())) {
//            Predicate bik = cb.equal(root.get(BNKSEEK_.newnum), filter.getBik().toString());
//            criteria = cb.and(criteria, bik);

            //parsing problem ?
            criteria = cb.and(criteria,
                    cb.like(root.get(BNKSEEK_.newnum),
                            "%" + filter.getBik().toString()));
        }

        if (StringUtils.isNotEmpty(filter.getRegion())) {
            criteria = cb.and(criteria,
                    cb.like(cb.lower(root.get(BNKSEEK_.rgn).get(REG_.name)),
                            "%" + filter.getRegion().toLowerCase() + "%"));
        }

        if (CollectionUtils.isNotEmpty(filter.getPzns())) {
            List<Long> ids = filter.getPzns().stream().map(BaseDto::getId).collect(Collectors.toList());
            Predicate pzn = root.get(BNKSEEK_.pzn).get(PZN_.id).in(ids);
            criteria = cb.and(criteria, pzn);
        }

        criteriaQuery.where(criteria);
        TypedQuery<BNKSEEK> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(filter.getFromNum());
        query.setMaxResults(filter.getCount());

        return query.getResultList();
    }

    @Override
    public Long getCount(BnkseekFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<BNKSEEK> root = criteriaQuery.from(BNKSEEK.class);

        criteriaQuery.select(cb.count(root));
        Predicate criteria = cb.conjunction();

        if (Objects.nonNull(filter.getBik())) {
//            Predicate bik = cb.equal(root.get(BNKSEEK_.newnum), filter.getBik().toString());
//            criteria = cb.and(criteria, bik);

            criteria = cb.and(criteria,
                    cb.like(root.get(BNKSEEK_.newnum),
                            "%" + filter.getBik().toString()));
        }

        if (StringUtils.isNotEmpty(filter.getRegion())) {
            criteria = cb.and(criteria,
                    cb.like(cb.lower(root.get(BNKSEEK_.rgn).get(REG_.name)),
                            "%" + filter.getRegion().toLowerCase() + "%"));
        }

        if (CollectionUtils.isNotEmpty(filter.getPzns())) {
            List<Long> ids = filter.getPzns().stream().map(BaseDto::getId).collect(Collectors.toList());
            Predicate pzn = root.get(BNKSEEK_.pzn).get(PZN_.id).in(ids);
            criteria = cb.and(criteria, pzn);
        }

        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
