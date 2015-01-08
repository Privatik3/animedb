package animedb.controller;

import animedb.servise.Parametrs;
import animedb.domain.AnimesEntity;
import animedb.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private UserDAO userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        List<AnimesEntity> listUsers = userDao.list();

		model.addAttribute("users", listUsers);

		return "test";
	}

    @RequestMapping(value = "/anime", method = RequestMethod.GET)
    public String printAnime(ModelMap model, HttpServletRequest request) {

        int animeId = Integer.parseInt(request.getParameter("id"));
        AnimesEntity anime = userDao.getAnimeById(animeId);

        model.addAttribute("anime", anime);

        return "anime";
    }

    @RequestMapping(value = "/topanime", method = RequestMethod.GET)
    public String printTopAnime(ModelMap model, HttpServletRequest request) {

        /*Parametrs param = new Parametrs();

        param.setDate(request.getParameter("year_production"));
        param.setGenres(request.getParameterValues("genres"));
        param.setPage(request.getParameter("1"));
        param.setType(request.getParameter("types"));
        param.setSortedType(request.getParameter("typesort"));*/

        //List<AnimesEntity> animes = userDao.getAnimeByParameters(param);

        List<AnimesEntity> animes = userDao.list();
        model.addAttribute("animes", animes);

        return "topanime";
    }
}