package iotbay.helper;

public class ProjectConstants {
// Database constants
    public static final String JDBC_SQLITE_PREFIX = "jdbc:sqlite:";
    public static final String DB_FILE_LOCATION = "src\\main\\db\\iotbay.db";
    public static final String DB_QUERIES_FOLDER = "src\\main\\db\\queries\\";
    // User table constants
    public static final String USER_COLUMN_USER_ID = "User_Id";
    public static final String USER_COLUMN_FIRST_NAME = "First_Name";
    public static final String USER_COLUMN_LAST_NAME = "Last_Name";
    public static final String USER_COLUMN_EMAIL = "Email";
    public static final String USER_COLUMN_PASSWORD = "Password";
    public static final String USER_COLUMN_HAS_ADMIN_PERMISSIONS = "Has_Admin_Permissions";
    public static final String USER_QUERY_CREATE = "CreateUser.sql";
    public static final String USER_QUERY_GET = "GetUser.sql";
    public static final String USER_QUERY_GET_ALL = "GetAllUsers.sql";
    public static final String USER_QUERY_UPDATE = "UpdateUser.sql";
    public static final String USER_QUERY_DELETE = "DeleteUser.sql";
    // Product table constants
    public static final String PRODUCT_COLUMN_PRODUCT_ID = "Product_Id";
    public static final String PRODUCT_COLUMN_PRODUCT_NAME = "Product_Name";
    public static final String PRODUCT_COLUMN_DESCRIPTION = "Description";
    public static final String PRODUCT_COLUMN_PRICE = "Price";
    public static final String PRODUCT_COLUMN_STOCK_QUANTITY = "Stock_Quantity";
    public static final String PRODUCT_COLUMN_CATEGORY = "Category";
    public static final String PRODUCT_QUERY_GET = "GetProduct.sql";
    public static final String PRODUCT_QUERY_GET_ALL = "GetAllProducts.sql";
    public static final String PRODUCT_QUERY_UPDATE = "UpdateProduct.sql";
    public static final String PRODUCT_QUERY_DELETE = "DeleteProduct.sql";

// Session attribute names
    public static final String SESSION_ATTRIBUTE_USER = "user";
    public static final String SESSION_ATTRIBUTE_DBCONNECTION = "dbConnection";
    public static final String SESSION_ATTRIBUTE_LOGIN_ERROR = "loginError";
    public static final String SESSION_ATTRIBUTE_REGISTER_ERROR = "registerError";

// Pages
    public static final String HOME_PAGE = "/";
    public static final String LOGIN_PAGE = "/login.jsp";
    public static final String REGISTER_PAGE = "/register.jsp";

// Request attribute names
    public static final String REQUEST_ATTRIBUTE_USER_FIRST_NAME = "firstName";
    public static final String REQUEST_ATTRIBUTE_USER_LAST_NAME = "lastName";
    public static final String REQUEST_ATTRIBUTE_USER_EMAIL = "email";
    public static final String REQUEST_ATTRIBUTE_USER_PASSWORD = "password";
    public static final String REQUEST_ATTRIBUTE_USER_HAS_ADMIN_PERMISSIONS = "hasAdminPermissions";

// Validator regex patterns
    public static final String VALIDATOR_EMAIL_PATTERN = ".*@.*";
    public static final String VALIDATOR_PASSWORD_PATTERN = "(^[A-Z])(?=.*\\d)(?=.*\\W).{11,}";
}
