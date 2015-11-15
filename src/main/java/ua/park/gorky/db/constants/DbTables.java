package ua.park.gorky.db.constants;


public class DbTables {


    public static class User {
        public static final String ID = "idUser";
        public static final String ROLE = "idRole";
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
        public static final String ID = "idNews";
        public static final String USER_ID = "idUser";
        public static final String TITLE = "title";
        public static final String BODY = "body";
        public static final String PICTURE = "news_picture";
        public static final String POST_DATE = "post_date";
    }

    //NEWS USER
    public static final String NEWS_USER_COUNT = "count";

    public static class Role {
        public static final String ID = "idRole";
        public static final String NAME = "name";
    }

    public static class Attraction {
        public static final String ID = "idAttraction";
        public static final String TITLE = "title";
        public static final String DESC = "description";
        public static final String HEIGHT = "height";
        public static final String PICTURE = "att_picture";
        public static final String ADULT_PRICE = "price_adult";
        public static final String CHILD_PRICE = "price_child";
    }

    public static class Comment {
        public static final String ID = "idComment";
        public static final String ID_USER = "idUser";
        public static final String ID_NEWS = "idNews";
        public static final String BODY = "body";
        public static final String WROTE_DATE = "wrote_date";
    }

}
