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
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.core.constants.Utility;
import ua.park.gorky.core.service.api.IAttractionService;
import ua.park.gorky.core.validator.api.IBeanValidator;
import ua.park.gorky.web.constants.WebConsts;
import ua.park.gorky.web.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav
 */
@Controller
@RequestMapping(WebConsts.Mapping.ATTRACTION_ROOT)
public class BasicAttractionController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAttractionController.class);

    @Autowired
    private IAttractionService attractionService;

    @Autowired
    private IBeanValidator beanValidator;

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
    public ModelAndView add(HttpServletRequest request, ModelMap modelMap) throws IOException, ServletException {

        AttractionBean bean = buildBean(modelMap);
        Map<String, List<String>> errors = beanValidator.validateBean(bean);
        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession();

        if (notValid(errors)) {
            modelAndView.setViewName(WebConsts.View.ATTRACTION_NEW);
            modelAndView.addObject(WebConsts.ClientSideEntities.VALIDATION_ERRORS, errors);
            session.setAttribute(WebConsts.ClientSideEntities.ATTRACTION_INVALID_BEAN, bean);
            LOGGER.debug("Validation not passed. Sending back: ");
            return modelAndView;
        }
        writeFile(request.getPart("inputImage"));
        modelAndView.setViewName(WebConsts.View.ATTRACTIONS);
        return modelAndView;
    }

    private boolean notValid(Map<String, List<String>> errors) {
        return !errors.isEmpty();
    }

    private AttractionBean buildBean(ModelMap modelMap) {
        String title = (String) modelMap.get("inputTitle");
        String desc = (String) modelMap.get("inputDesc");
        String height = (String) modelMap.get("inputHeight");
        String adultPrice = (String) modelMap.get("inputAdultPrice");
        String childPrice = (String) modelMap.get("inputChildPrice");

        AttractionBean bean = new AttractionBean();
        bean.setTitle(title);
        bean.setDescription(desc);
        bean.setHeight(height);
        bean.setAdultPrice(adultPrice);
        bean.setChildPrice(childPrice);
        return bean;
    }

    private void writeFile(Part imagePart) throws IOException {
        String savePath = Path.ATTRACTION_IMAGES;

        File folder = new File(savePath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String picPath = savePath + File.separator + Utility.createNewPath();
        imagePart.write(picPath);
    }

}
