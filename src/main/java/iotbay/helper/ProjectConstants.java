package iotbay.helper;

// This class contains all the constants used in the project, in order to avoid hardcoding and typos
public class ProjectConstants {
// Database constants
    public static final String JDBC_SQLITE_PREFIX = "jdbc:sqlite:";
    public static final String WINDOWS_DB_FILE_LOCATION = "src\\main\\db\\iotbay.db";
    public static final String WINDOWS_DB_QUERIES_FOLDER = "src\\main\\db\\queries\\";
    public static final String MAC_DB_FILE_LOCATION = "src/main/db/iotbay.db";
    public static final String MAC_DB_QUERIES_FOLDER = "src/main/db/queries/";
    public static final String OS = System.getProperty("os.name").split(" ")[0];
    public static final String WINDOWS_SLASH = "\\";
    public static final String MAC_SLASH = "/";
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
    public static final String PRODUCT_QUERY_CREATE = "CreateProduct.sql";
    public static final String PRODUCT_QUERY_GET = "GetProduct.sql";
    public static final String PRODUCT_QUERY_GET_ALL = "GetAllProducts.sql";
    public static final String PRODUCT_QUERY_UPDATE = "UpdateProduct.sql";
    public static final String PRODUCT_QUERY_DELETE = "DeleteProduct.sql";
    // Orders table constants
    public static final String ORDERS_COLUMN_ORDER_ID = "Order_Id";
    public static final String ORDERS_COLUMN_DELIVERY_ADDRESS = "Delivery_Address";
    public static final String ORDERS_COLUMN_DELIVERY_STATUS = "Delivery_Status";
    public static final String ORDERS_COLUMN_CARD_NUMBER = "Card_Number";
    public static final String ORDERS_QUERY_CREATE_ORDER = "CreateOrder.sql";
    public static final String ORDERS_QUERY_GET_ALL_ORDERS = "GetAllOrders.sql";
    // OrderProduct table constants
    public static final String ORDERPRODUCT_COLUMN_QUANTITY = "Quantity";
    public static final String ORDERPRODUCT_QUERY_CREATE_ORDER_PRODUCT = "CreateOrderProduct.sql";
    public static final String ORDERPRODUCT_QUERY_GET_ALL_ORDER_PRODUCTS = "GetAllOrderProducts.sql";

// Session attribute names
    public static final String SESSION_ATTRIBUTE_USER = "user";
    public static final String SESSION_ATTRIBUTE_DBCONNECTION = "dbConnection";
    public static final String SESSION_ATTRIBUTE_ERROR = "error";
    public static final String SESSION_ATTRIBUTE_SUCCESS_MESSAGE = "successMessage";
    public static final String SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT = "currentlySelectedProduct";
    public static final String SESSION_ATTRIBUTE_PRODUCT_LIST = "productList";
    public static final String SESSION_ATTRIBUTE_CART = "cart";

// Pages
    public static final String HOME_PAGE = "/";
    public static final String LOGIN_PAGE = "/login.jsp";
    public static final String REGISTER_PAGE = "/register.jsp";
    public static final String MANAGE_PRODUCTS_PAGE = "/manageProducts.jsp";
    public static final String PRODUCT_DETAILS_PAGE = "/productDetails.jsp";
    public static final String MANAGE_ACCOUNT_PAGE = "/manageAccount.jsp";
    public static final String PLACE_ORDER_PAGE = "/placeorder.jsp";
    public static final String SEARCH_PAGE = "/search.jsp";
    public static final String BROWSE_PAGE = "/browseProducts.jsp";

// Request attribute names
    public static final String REQUEST_ATTRIBUTE_USER_FIRST_NAME = "firstName";
    public static final String REQUEST_ATTRIBUTE_USER_LAST_NAME = "lastName";
    public static final String REQUEST_ATTRIBUTE_USER_EMAIL = "email";
    public static final String REQUEST_ATTRIBUTE_USER_PASSWORD = "password";
    public static final String REQUEST_ATTRIBUTE_USER_HAS_ADMIN_PERMISSIONS = "hasAdminPermissions";
    public static final String REQUEST_ATTRIBUTE_DESCRIPTION = "description";
    public static final String REQUEST_ATTRIBUTE_PRICE = "price";
    public static final String REQUEST_ATTRIBUTE_STOCK = "stock";
    public static final String REQUEST_ATTRIBUTE_CATEGORY = "category";
    public static final String REQUEST_ATTRIBUTE_PRODUCT_ID = "productId";
    public static final String REQUEST_ATTRIBUTE_PAGE = "page";

// Validator regex patterns
    public static final String VALIDATOR_EMAIL_PATTERN = ".*@.*";
    public static final String VALIDATOR_PASSWORD_PATTERN = "(^[A-Z])(?=.*\\d)(?=.*\\W).{11,}";
}
