package ua.park.gorky.web.constants;

/**
 * @author Vladyslav
 */
public class WebConsts {
    public static final String REDIRECT = "redirect:";
    public static final String REFERER = "referer";
    public static final String LOGGED_USER = "loggedUser";
    public static final String LOGGED_USER_ROLE = "userRole";

    public static class View {
        public static final String ATTRACTION = "client/attraction";
        public static final String ATTRACTIONS = "client/attractions";
        public static final String ATTRACTION_NEW = "admin/newAttraction";
        public static final String REGISTER = "register";
        public static final String ADMIN_REGISTER = "admin/register";
        public static final String HOME = "index";

        private View() {
        }
    }

    public static class Mapping {
        public static final String ATTRACTION = "/attraction";

        public static final String USER = "/user";
        public static final String ADMIN = "/admin";
        public static final String ROLE = "/role";

        public static final String IMAGE = "/image";

        public static final String ADD = "/add";
        public static final String VIEW = "/view";
        public static final String ID = "/${id}";
        public static final String PAGE = "/page";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";

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

        private ClientSideEntities() {
        }

    }

    private WebConsts() {
    }
}
