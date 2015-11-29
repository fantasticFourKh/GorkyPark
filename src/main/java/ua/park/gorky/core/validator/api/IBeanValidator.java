package ua.park.gorky.core.validator.api;

import org.springframework.stereotype.Component;
import ua.park.gorky.core.bean.ViewBean;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
@Component
public interface IBeanValidator {
	Map<String, List<String>> validateBean(ViewBean bean);

}
