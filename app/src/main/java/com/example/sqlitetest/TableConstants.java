package com.example.sqlitetest;

import android.provider.BaseColumns;

public class TableConstants {
    class VolumeInfo implements BaseColumns{

    }
    class ImageLinks implements BaseColumns{

    }
    class UserDetails implements BaseColumns{
        public static final String TABLE_NAME="userDetails";
        public static final String NAME_COLUMN="name";
        public static final String BIRTHDAY_COLUMN="birthday";
        public static final String USERNAME_COLUMN="username";
        public static final String PASSWORD_COLUMN="password";
        public static final String COUNTRY_COLUMN="country";
        public static final String ADDRESS_COLUMN="address";
        public static final String GENDER_COLUMN="gender";

    }
}
