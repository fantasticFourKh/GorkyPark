package ua.park.gorky.web.converter;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Vladyslav_Yemelianov
 */
public class RequestConverter {

    public static ModelMap convertToModelMap(HttpServletRequest request) {
        ModelMap map = new ModelMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            map.addAttribute(entry.getKey(), entry.getValue()[0]);
        }
        return map;
    }

    private RequestConverter(){}
}
