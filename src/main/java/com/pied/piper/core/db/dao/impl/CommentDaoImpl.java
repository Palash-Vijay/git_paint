package com.pied.piper.core.db.dao.impl;

import com.google.inject.Inject;
import com.pied.piper.core.db.dao.api.BaseDao;
import com.pied.piper.core.db.model.Comment;
import com.pied.piper.core.db.model.ImageLikes;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

/**
 * Created by ankit.c on 22/07/16.
 */
public class CommentDaoImpl extends BaseDaoImpl<Comment, Long> implements BaseDao<Comment, Long> {

    @Inject
    public CommentDaoImpl(Provider<EntityManager> entityManagerProvider) {
        super(entityManagerProvider);
        this.entityClass = Comment.class;
    }

    public List<Comment> findByImageId(Long imageId){
        if(imageId == null)
            return Collections.EMPTY_LIST;
        Session session = (Session) getEntityManager().getDelegate();
        Criteria criteria = session.createCriteria(Comment.class);
        Criterion typeCriterion = Restrictions.eq("image.imageId", imageId);
        criteria.add(typeCriterion);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    public List<Comment> findByAccountId(String accountId){
        if(StringUtils.isEmpty(accountId))
            return Collections.EMPTY_LIST;
        Session session = (Session) getEntityManager().getDelegate();
        Criteria criteria = session.createCriteria(Comment.class);
        Criterion typeCriterion = Restrictions.eq("accountId", accountId);
        criteria.add(typeCriterion);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}
