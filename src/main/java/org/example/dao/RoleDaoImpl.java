package org.example.dao;

import org.example.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRole(String roleName) {
        return (Role) sessionFactory.getCurrentSession()
                .createQuery("from Role r where r.name =:roleName")
                .setParameter("roleName", roleName)
                .uniqueResult();
    }
}
