package ua.park.gorky.web.constants;

/**
 * @author Vladyslav
 */
public class WebConsts {

    public static class View {
        public static final String ATTRACTION = "client/attraction";
        public static final String ATTRACTIONS = "client/attractions";

        private View(){}
    }

    public static class Mapping {
        public static final String ATTRACTION_ROOT = "/attraction";
        public static final String IMAGE = "/image";


        public static final String ADD = "/add";
        public static final String VIEW = "/view";
        public static final String ID = "/${id}";

        private Mapping(){}
    }

    public static class ClientSideEntities {
        public static final String ATTRACTION = "attraction";
        public static final String ATTRACTIONS = "attractions";

    }

    private WebConsts(){}
}
