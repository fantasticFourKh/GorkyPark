package ua.park.gorky.web.controller.attraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.bean.AttractionBean;
import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.core.entity.constants.Utility;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.core.service.api.IAttractionService;
import ua.park.gorky.db.dao.attraction.AttractionDAO;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;
import ua.park.gorky.web.constants.WebConsts;
import ua.park.gorky.web.controller.AbstractController;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;

/**
 * @author Vladyslav
 */
@Controller
@RequestMapping(WebConsts.Mapping.ATTRACTION_ROOT)
public class BasicAttractionController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAttractionController.class);

    @Autowired
    private IAttractionService attractionService;

    @RequestMapping(value = WebConsts.Mapping.VIEW, method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = createMaV(WebConsts.View.ATTRACTIONS);

        modelAndView.addObject(WebConsts.ClientSideEntities.ATTRACTIONS, attractionService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = WebConsts.Mapping.ID, method = RequestMethod.GET)
    public ModelAndView get(@RequestParam int id) {
        ModelAndView modelAndView = createMaV(WebConsts.View.ATTRACTION);

        modelAndView.addObject(WebConsts.ClientSideEntities.ATTRACTION, attractionService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = WebConsts.Mapping.ADD, method = RequestMethod.POST)
    public ModelAndView add(@RequestParam HttpSession session, ModelMap modelMap) {

        AttractionBean bean = buildBean(modelMap);

        String errorMessage = null;

        String picPath = null;
        String savePath = Path.ATTRACTION_IMAGES;


        if (title.isEmpty() || desc.isEmpty() || desc.isEmpty()
                || heightStr.isEmpty()
                || adultPriceStr.isEmpty() || childPriceStr.isEmpty()) {
            response.sendRedirect(request.getHeader("referer") + "#add_form");
            errorMessage = "�� ��� ���� ���������";
            session.setAttribute("addErrorMessage", errorMessage);
            LOGGER.debug("Empty field");
            return null;
        }

        try {
            height = Integer.parseInt(heightStr);
            adultPrice = Integer.parseInt(adultPriceStr);
            childPrice = Integer.parseInt(childPriceStr);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getHeader("referer") + "#add_form");
            errorMessage = "�������� ������";
            session.setAttribute("addErrorMessage", errorMessage);
            LOGGER.debug("Empty field");
            return null;
        }

        Part part = request.getPart("image");
        picPath = savePath + File.separator + Utility.createNewPath();
        part.write(picPath);

        Attraction attraction = new Attraction();
        attraction.setTitle(title);
        attraction.setDescription(desc);
        attraction.setHeight(height);
        attraction.setAdultPrice(adultPrice);
        attraction.setChildPrice(childPrice);
        attraction.setImage(picPath);
        IAttractionDAO dao = new AttractionDAO();

        try {
            dao.addAttraction(attraction);
            String message = "�������� ����������";
            session.setAttribute("message", message);
            LOGGER.debug("message --> " + message);
            response.sendRedirect(Path.COMMAND_VIEW_ATTRATIONS);
            return null;

        } catch (DBLayerException ex) {
            errorMessage = "������";
            session.setAttribute("addErrorMessage", errorMessage);
            response.sendRedirect(request.getHeader("referer") + "#add_form");
            LOGGER.error(ex.getMessage());
            return null;
        }

        ModelAndView modelAndView = new ModelAndView("ViewName");
        return modelAndView;
    }

    private AttractionBean buildBean(ModelMap modelMap) {
        String title = (String) modelMap.get("title");
        String desc = (String) modelMap.get("desc");
        String height = (String) modelMap.get("height");
        String adultPrice = (String) modelMap.get("adultPrice");
        String childPrice = (String) modelMap.get("childPrice");

        AttractionBean bean = new AttractionBean();
        bean.setTitle(title);
        bean.setDescription(desc);
        bean.setHeight(height);
        bean.setAdultPrice(adultPrice);
        bean.setChildPrice(childPrice);
        return bean;
    }

}
