package ua.park.gorky.db.constants;


public class DbTables {


    public static class User {
        public static final String ID = "id_user";
        public static final String ROLE = "id_role";
        public static final String LOGIN = "login";
        public static final String PASS = "password";
        public static final String NAME = "first_name";
        public static final String LNANE = "last_name";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String REG_DATE = "reg_date";
        public static final String STATUS = "status_banned";
        public static final String DOB = "dob";
        public static final String SALT = "salt";
    }

    //NEWS
    public static class News {
        public static final String ID = "id_news";
        public static final String USER_ID = "id_user";
        public static final String TITLE = "title";
        public static final String BODY = "body";
        public static final String PICTURE = "news_picture";
        public static final String POST_DATE = "post_date";
    }

    public static class Attraction {
        public static final String ID = "id_attraction";
        public static final String TITLE = "title";
        public static final String DESC = "description";
        public static final String HEIGHT = "height";
        public static final String PICTURE = "att_picture";
        public static final String ADULT_PRICE = "price_adult";
        public static final String CHILD_PRICE = "price_child";
    }

    public static class Comment {
        public static final String ID = "id_comment";
        public static final String ID_USER = "id_user";
        public static final String ID_NEWS = "id_news";
        public static final String BODY = "body";
        public static final String WROTE_DATE = "wrote_date";
    }

}
