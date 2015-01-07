package home.privatik.spring.controller;

import home.privatik.spring.dao.UserDAO;
import home.privatik.spring.domain.AnimesEntity;
import home.privatik.spring.domain.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserDAO userDao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        List<AnimesEntity> listUsers = userDao.list();

		model.addAttribute("users", listUsers);

		return "test";
	}
}