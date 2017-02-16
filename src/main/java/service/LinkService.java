package service;

import domain.Link;

import java.util.List;

public interface LinkService {
    public void addLink(Link link);

    public List<Link> listLink();

    public void removeLink(Integer id);
}
