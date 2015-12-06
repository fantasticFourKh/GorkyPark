package ua.park.gorky.web.constants;

/**
 * @author Vladyslav
 */
public class WebConsts {
    public static final String REDIRECT = "redirect:";
    public static final String REFERER = "referer";
    public static final String REDIRECT_REFERER = REDIRECT + REFERER;
    public static final String LOGGED_USER = "loggedUser";
    public static final String LOGGED_USER_ROLE = "userRole";

    public static final String FOLDER_CLIENT = "client/";
    public static final String FOLDER_ADMIN = "admin/";

    public static class View {
        public static final String ATTRACTION = FOLDER_CLIENT + "attraction";
        public static final String ATTRACTIONS = FOLDER_CLIENT + "attractions";
        public static final String USER_PROFILE = FOLDER_CLIENT + "user_profile";
        public static final String PROFILE = FOLDER_CLIENT + "profile";
        public static final String NEWS = FOLDER_CLIENT + "news";

        public static final String ADMIN_REGISTER = FOLDER_ADMIN + "register";
        public static final String ATTRACTION_NEW = FOLDER_ADMIN + "newAttraction";
        public static final String ALL_USERS = FOLDER_ADMIN + "users";
        public static final String NEWS_NEW = FOLDER_ADMIN + "newNews";

        public static final String REGISTER = "register";
        public static final String INDEX = "index";
        public static final String ERROR = "error_page";

        private View() {
        }
    }

    public static class Mapping {
        public static final String ATTRACTION = "/attraction";

        public static final String USER = "/user";
        public static final String ADMIN = "/admin";
        public static final String ROLE = "/role";
        public static final String NEWS = "/news";
        public static final String HOME = "/home";
        public static final String COMMENT = "/comment";

        public static final String IMAGE = "/image";

        public static final String ADD = "/add";
        public static final String EDIT = "/edit";
        public static final String DELETE = "/delete";
        public static final String VIEW = "/view";
        public static final String ID = "/${id}";
        public static final String PAGE = "/page";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String PROFILE = "/profile";
        public static final String STATUS = "/status";

        private Mapping() {
        }
    }

    public static class ClientSideEntities {
        public static final String ATTRACTION = "attraction";
        public static final String ATTRACTIONS = "attractions";
        public static final String ATTRACTION_INVALID_BEAN = "invalidAttractionBean";

        public static final String USER_INVALID_BEAN = "invalidUserBean";
        public static final String VALIDATION_ERRORS = "validationErrors";
        public static final String INVALID_LOGIN = "invalidLogin";

        public static final String ROLES = "roles";

        public static final String ERROR_CODE = "code";
        public static final String ERROR_MSG = "errorMessage";

        public static final String NEWS = "news";
        public static final String NEWS_INVALID_BEAN = "invalidNewsBean";
        public static final String COMMENTS = "comments";

        private ClientSideEntities() {
        }

    }

    public static class ErrorCodes {
        public static final String NOT_FOUND = "404. NOT FOUND";

        private ErrorCodes() {}
    }

    private WebConsts() {
    }
}
