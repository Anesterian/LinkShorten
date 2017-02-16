package service;

import dao.LinkDao;
import domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinkServiceImlp implements LinkService{
    @Autowired
    private LinkDao linkDao;

    @Transactional
    public  void addLink(Link link){
        linkDao.addLink(link);
    }
    @Transactional
    public List<Link> listLink(){
        return linkDao.listLink();
    }
    @Transactional
    public void removeLink(Integer id){
        linkDao.removeLink(id);
    }
}
