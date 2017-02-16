package web;

import domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.LinkService;

import java.util.Map;

@Controller
public class LinkController {
    @Autowired
    private LinkService linkService;
    @RequestMapping("/index")
    public  String listLinks(Map<String, Object> map){
        map.put("link", new Link());
        map.put("linkList", linkService.listLink());
        return "link";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLink(@ModelAttribute("link") Link link,
                             BindingResult result) {

        linkService.addLink(link);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{linkId}")
    public String deleteLink(@PathVariable("linkId") Integer linkId) {

        linkService.removeLink(linkId);

        return "redirect:/index";
    }
}
