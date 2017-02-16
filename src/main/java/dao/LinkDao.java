package dao;

import domain.Link;

import java.util.List;
public interface LinkDao {
    public  void addLink(Link link);
    public List<Link> listLink();
    public void removeLink(Integer id);
}
