package ua.park.gorky.web.command.attraction;

import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.core.constants.Utility;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.db.dao.attraction.AttractionDAO;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;
import ua.park.gorky.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class AddAttractionCommand extends Command {

    private final IAttractionDAO attractionDAO = new AttractionDAO();

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        String heightStr = request.getParameter("height");
        String adultPriceStr = request.getParameter("adult_price");
        String childPriceStr = request.getParameter("child_price");

        int adultPrice = 0;
        int childPrice = 0;
        int height = 0;

        String errorMessage = null;

        String picPath = null;
        String savePath = Path.ATTRACTION_IMAGES;


        if (title.isEmpty() || desc.isEmpty() || desc.isEmpty()
                || heightStr.isEmpty()
                || adultPriceStr.isEmpty() || childPriceStr.isEmpty()) {
            response.sendRedirect(request.getHeader("referer") + "#add_form");
            errorMessage = "�� ��� ���� ���������";
            session.setAttribute("addErrorMessage", errorMessage);
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

        try {
            attractionDAO.addAttraction(attraction);
            String message = "�������� ����������";
            session.setAttribute("message", message);
            response.sendRedirect(Path.COMMAND_VIEW_ATTRATIONS);
            return null;
        } catch (DBLayerException e) {
            errorMessage = "������";
            session.setAttribute("addErrorMessage", errorMessage);
            response.sendRedirect(request.getHeader("referer") + "#add_form");
            return null;
        }
    }


}
