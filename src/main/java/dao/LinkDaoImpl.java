package dao;

import domain.Link;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LinkDaoImpl implements LinkDao{
    @Autowired
    private SessionFactory sessionFactory;
    public void addLink(Link link) {
        sessionFactory.getCurrentSession().save(link);
    }

    @SuppressWarnings("unchecked")
    public List<Link> listLink() {

        return sessionFactory.getCurrentSession().createQuery("from Link").list();
    }

    public void removeLink(Integer id) {
        Link link = (Link) sessionFactory.getCurrentSession().load(
                Link.class, id);
        if (null != link) {
            sessionFactory.getCurrentSession().delete(link);
        }

    }
}
