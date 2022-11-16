package com.bitsco.vks.constant;

/*
 * Declare constants used in the project
 */
public interface Constant {
    //file config in lib_common
    public static final String FILE_CONFIG = "config_common.properties";
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE_APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
    public static final String UTF_8 = "UTF-8";
    public static final String EMPTY = "";
    public static final String BLANK = " ";
    public static final String DASH = "-";
    public static final String DOT = "\\.";
    public static int MAX_LENGTH_RESPONSE_CODE = 4;
    public static final int ZERO = 0;
    public static final int FIRST = 1;
    public static final int SECOND = 2;

    interface ENVIRONMENT {
        public static final String PRODUCTION = "production";
        public static final String TEST = "test";
        public static final String DEV = "dev";
    }

    interface EMAIL {
        interface TYPE {
            public static final int NOTIFICATION = 1;
            public static final int CONFIRM = 2;
        }

        interface STATUS {
            public static final int NEW = 0;
            public static final int SUCCESS = 1;
            public static final int ERROR = 2;
            public static final int TIME_OUT = 4;
        }
    }

    interface USER {
        interface STATUS {
            public static final int ACTIVE = 1;
            public static final int INACTIVE = 0;
            public static final int WAIT_FOR_CONFIRM_EMAIL = 2;
        }
    }

    interface ROLE {
        interface TYPE {
            public static final int MENU = 1;
        }
    }

    interface GROUP_ROLE {
        interface TYPE {
            public static final int MENU = 1;
        }
    }

    interface OTP {
        public static final long EXPIRY_DEFAULT = 300000;//5 phut
        public static final int TYPE_DEFAULT = 1;

        interface RESET {
            public static final long EXPIRY = 300000;//5 phut
            public static final int TYPE = 1;
        }
    }

    interface PARAMS {
        String ALPHA_NUMERIC_STRING = "0123456789abcdefghijklmnopqrstuvxyz";

        interface GROUP {
            public static final String CHECK_STOCK = "CHECK_STOCK";
            public static final String EVN_CUSTOMER_BILL = "EVN_CUSTOMER_BILL";
        }

        interface TYPE {
            public static final String NPP = "NPP";
        }

    }


    interface CRYPT {
        interface MD5 {
            public static final String ALGORITHM = "MD5";
            public static byte[] HEX_ARRAY = new byte[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        }
    }

    interface STATUS_OBJECT {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;
        public static final int ALL = -1;
    }

    interface DATE {
        interface FORMAT {
            public static final String DATE_TIME_STAMP = "HH:mm:ss.SSS dd/MM/yyyy";
            public static final String DATE_TIME = "HH:mm:ss dd/MM/yyyy";
            public static final String DATE = "dd/MM/yyyy";
            public static final String TIME = "HH:mm:ss";
        }
    }


    interface LOG_APPENDER {
        public static final String CONTROLLER = "controller";
        public static final String COMMON = "common";
        public static final String CONNECTION = "connection";
        public static final String APPLICATION = "application";
        public static final String PRE_FILTER = "pre_filter";
        public static final String JOB = "job";
        public static final String SERVICE = "service";
        public static final String SUPPLIER = "supplier";
        public static final String THREAD = "thread";
    }

    interface PAGE {
        interface DEFAULT_VALUE {
            public static final String ASC_ORDER = "ASC";
            public static final String DESC_ORDER = "DESC";
            public static final int PAGE_DEFAULT = 1;
            public static final int SIZE_FIFTY = 50;
            public static final int SIZE_ALL = 0;
            public static final int PAGE_ALL = 0;
        }
    }

    interface KEY {
        public static final String USER_ID = "user_id";
        public static final String USERNAME = "username";
        public static final String USER_TYPE = "user_type";
        public static final String EVN = "EVN";
        public static final String ZOTA = "ZOTA";
    }

    //Declare TABLE used in the DATABASE
    interface TABLE {
        public static final String ROLE = "role";
        public static final String USER_ROLE = "user_role";
        public static final String GROUP_ROLE = "group_role";
        public static final String USER_GROUP_ROLE = "user_group_role";
        public static final String GROUP_ROLE_MAP = "group_role_map";
        public static final String PARAM = "params";
        public static final String USER = "user";
        public static final String LOG = "log";
        public static final String EMAIL = "email";
        public static final String CUSTOMER = "customer";
        public static final String BILL = "bill";
        public static final String BANK = "bank";
        public static final String BILL_INDICATOR = "bill_indicator";
        public static final String METER = "meter";
        public static final String METER_INDEX = "meter_index";
        public static final String PROVINCE = "province";
        public static final String COMMUNE = "commune";
        public static final String DISTRICT = "district";
        public static final String VILLAGE = "village";
        public static final String BILL_PAYMENT = "bill_payment";
        public static final String TRANSACTION = "transaction";
        public static final String LIMIT_AMOUNT = "limit_amount";
        public static final String LIMIT_AMOUNT_HISTORY = "limit_amount_history";
        public static final String LIMIT_TRANS = "limit_trans";
        public static final String LIMIT_TRANS_HISTORY = "limit_trans_history";
        public static final String SUPPLIER = "supplier";
        public static final String POSITION = "position";
        public static final String POSITION_GROUP_ROLE = "position_group_role";
        public static final String INDEX_METER = "index_meter";
        public static final String EVN_PC = "evn_pc";
        public static final String BIG_CUSTOMER = "big_customer";
        public static final String LOG_GATEWAY = "log_gateway";
        public static final String USER_RELATIONSHIP = "user_relationship";
    }

    //Declare SEQUENCE used in the DATABASE
    interface SEQUENCE {
        //NPC services
        public static final String SQ_BILL = "SQ_BILL";
        public static final String SQ_CUSTOMER = "SQ_CUSTOMER";
        public static final String SQ_EVNPC_CDRTIME = "sq_evnpc_cdrtime";
        public static final String SQ_HOLIDAY = "sq_holiday";
        public static final String SQ_EVN_PC = "sq_evn_pc";
        public static final String SQ_EVNPC_LIMIT = "sq_evnpc_limit";
        public static final String SQ_BOOK_CMIS = "sq_book_cmis";
        public static final String SQ_EVNPC_ASSIGN = "sq_evnpc_assign";
        public static final String SQ_PENDING_REQUEST = "sq_pending_request";
        public static final String SQ_PENDING_TRANSACTION = "SQ_PENDING_TRANSACTION";
        public static final String SQ_TRANSACTION = "SQ_TRANSACTION";
        public static final String SQ_METHOD = "sq_method";
        public static final String SQ_PENDING_CONFIG = "sq_pending_config";
        public static final String SQ_EVNPC_METHOD_CONFIG = "SQ_EVNPC_METHOD_CONFIG";
        public static final String SQ_SIMULATE_SUPPLIER_DATA = "SQ_SIMULATE_SUPPLIER_DATA";

        //Category services
        interface CATEGORY {
            public static final String SQ_COMMAND = "sq_command";
            public static final String SQ_SUPPLIER_COMMAND = "sq_supplier_command";
            public static final String SQ_CHANNEL_COMMAND = "sq_channel_command";
            public static final String SQ_SERVICES = "sq_services";
            public static final String SQ_DISTRIBUTOR = "sq_distributor";
            public static final String SQ_TRANSACTION_CONFIG = "sq_transaction_config";
            public static final String SQ_ATTRIBUTE = "sq_attribute";
            public static final String SQ_TRANSACTION = "sq_transaction";
            public static final String SQ_ATTRIBUTE_VALUE = "sq_attribute_value";
            public static final String SQ_API = "sq_api";
            public static final String SQ_API_PARAM = "sq_api_param";
            public static final String SQ_API_RESULT = "sq_api_result";
        }
    }

    interface METER_INDEX {
        interface STATUS {
            public static final int NEW = 0;
            public static final int UPDATE = 1;
        }

        interface TYPE {
            public static final int INDEX_PERIOD = 1;
            public static final int REPAIR = 2;
        }
    }

    interface REST_FULL {
        public static final String HTTP_STATUS = "HTTP_STATUS";
        public static final String RESPONSE_BODY = "RESPONSE_BODY";
        public static final String RESPONSE = "RESPONSE";
    }

    interface BILL {
        interface STATUS {
            public static final int UNPAID = 0;
            public static final int PAID = 1;
        }
    }

    interface TRANSACTION {
        interface STATUS {
            public static final int NEW = 0;
            public static final int SUCCESS = 1;
            public static final int PENDING = 2;
            public static final int ERROR = 3;
            public static final int TIME_OUT = 4;
            public static final int REVERT = 5;
        }

        interface TYPE {
            public static final int BILLING = 1;
            public static final int REVERT = 2;
        }
    }

    interface FEIGN_CLIENT {
        public static final String AUTH = "AUTH";
        public static final String CATEGORY = "CATEGORY";
        public static final String NOTIFICATION = "NOTIFICATION";

    }

    interface PACKAGE {
        static String PKG_REGISTER_DECISION = "PKG_REGISTER_DECISION";
        static String PKG_SPP_ACCSPLIT_UPINFO = "PKG_SPP_ACCSPLIT_UPINFO";
        static String PKG_SPP_JOINCASE = "PKG_SPP_JOINCASE";
        static String PKG_ADM_GROUPS = "PKG_ADM_GROUPS";
        static String PKG_MENU = "PKG_MENU";
        static String PKG_LST_PARTY = "PKG_LST_PARTY";
        static String PKG_LST_OFFICE = "PKG_LST_OFFICE";
        static String PKG_ADM_DEPARTMENTS = "PKG_ADM_DEPARTMENTS";
        static String PKG_LST_STATISTICA = "PKG_LST_STATISTICA";
        static String PKG_LST_STATISTICC = "PKG_LST_STATISTICC";
        static String PKG_LST_AGAINST_RESULT = "PKG_LST_AGAINST_RESULT";
        static String PKG_LST_AGAINST = "PKG_LST_AGAINST";
        static String PKG_LST_APPEAL = "PKG_LST_APPEAL";
        static String PKG_LST_CONCLUTION = "PKG_LST_CONCLUTION";
        static String PKG_LST_CUSTOMS = "PKG_LST_CUSTOMS";
        static String PKG_LST_RESOLVE = "PKG_LST_RESOLVE";
        static String PKG_LST_CODE = "PKG_LST_CODE";
        static String PKG_LST_RULE = "PKG_LST_RULE";
        static String PKG_LST_TRANSFER = "PKG_LST_TRANSFER";
        static String PKG_LST_LAWGROUP = "PKG_LST_LAWGROUP";
        static String PKG_KNOWLEDGE = "PKG_KNOWLEDGE";
        static String PKG_LST_SPC = "PKG_LST_SPC";
        static String PKG_LST_OCCUPATION = "PKG_LST_OCCUPATION";
        static String PKG_LST_RELIGION = "PKG_LST_RELIGION";
        static String PKG_LST_NATION = "PKG_LST_NATION";
        static String PKG_LST_COUNTRY = "PKG_LST_COUNTRY";
        static String PKG_LST_SPP = "PKG_LST_SPP";
        static String PKG_LST_REASON = "PKG_LST_REASON";
        static String PKG_LST_DECITYPE = "PKG_LST_DECITYPE";
        static String PKG_LST_LAW = "PKG_LST_LAW";
        static String PKG_LST_PENALTY = "PKG_LST_PENALTY";
        static String PKG_LST_DECISION = "PKG_LST_DECISION";
        static String PKG_LST_LAWPENALTY = "PKG_LST_LAWPENALTY";
        static String PKG_LST_LAWGROUPCHAP = "PKG_LST_LAWGROUPCHAP";
        static String PKG_ADM_USERS = "PKG_ADM_USERS";
        static String PKG_LST_ARMY = "PKG_LST_ARMY";
        static String PKG_LST_RANGER = "PKG_LST_RANGER";
        static String PKG_LST_POLI = "PKG_LST_POLI";
        static String PKG_LST_BORDERGUARDS = "PKG_LST_BORDERGUARDS";
        static String PKG_SUMMARY_REPORTS = "PKG_SUMMARY_REPORTS";
        static String PKG_MONITOR_REGISTER = "PKG_MONITOR_REGISTER_2022";
        static String PKG_MONITOR_CASE = "PKG_MONITOR_CASE_2022";
        static String PKG_MONITOR_AGAINST = "PKG_MONITOR_AGAINST_2022";
        static String PKG_MONITOR_APPEAL = "PKG_MONITOR_APPEAL_2022";
        static String PKG_MONITOR = "PKG_MONITOR_2022";
        static String PKG_MONITOR_NEW = "PKG_MONITOR_NEW";
        static String PKG_LOOKUP_NEW = "PKG_LOOKUP_NEW";
        static String PKG_DATAVERIFY = "PKG_DATAVERIFY_2022";

    }

    interface FUNCTION {
        static String GET_LIST_REGISTER_DECISION = "get_list_register_decision";
        static String FN_SEARCH_CASE = "fn_search_case";
        static String FN_SEARCH_CASE1 = "fn_search_case1";
        static String FN_SEARCHCASESPLIT = "fn_searchCaseSplit";
        static String FN_SEARCH_SPLIT = "fn_search_split";
        static String FN_SEARCH1 = "fn_search1";
        static String FN_INSERT_UPDATE_2022_ACCUSED = "fn_insert_update_2022_ACCUSED";
        static String FN_DELETE_SPLIT_2022_ACCUSED = "fn_delete_split_2022_ACCUSED";
        static String FN_INSERT_CASEACC = "insert_caseAcc";
        static String FN_INSERT_UPDATE = "fn_insert_update";
        static String FN_INSERT_UPDATE_2022 = "fn_insert_update_2022";
        static String FN_SEARCH = "fn_search";
        static String FN_DELETE = "fn_delete";
        static String FN_CHANGEPWD = "fn_changepwd";
        static String FN_GET_TREE_FOR_GROUP = "fn_get_tree_for_group_2022";
        static String FN_REVOKE_FUNCS_OF_GROUP = "fn_revoke_funcs_of_group";
        static String FN_GRANT_FUNC_TO_GROUP = "fn_grant_func_to_group";
        static String FN_AUTOCOMPLETE = "FN_AUTOCOMPLETE";
        static String FN_GET = "FN_GET";
        static String FN_INSERT = "fn_insert";
        static String FN_UPDATE = "fn_update";
        static String FN_GETID = "fn_getid";
        static String FN_GET_LIST = "fn_get_list";
        static String FN_LOADLSTREASON_HS = "Fn_loadLstReason_Hs";
        static String FN_FIND_ACC = "fn_find_acc";
        static String FN_GET_LST_CODE = "fn_get_lst_code";
        static String FN_GET_LST_LAWGROUP = "fn_get_lst_lawgroup";
        static String FN_LISTDECITYPE = "fn_listdecitype";
        static String FN_LSTDECISION_HS = "fn_lstdecision_hs";
        static String FN_DELETE_ALL = "fn_delete_all";
        static String FN_INSERT_FOR_UPDATE = "fn_insert_for_update";
        static String FN_SEARCH_UPDATE = "fn_search_update";
        static String FN_GET_LST_INSPECTORS = "fn_get_lst_inspectors";
        static String FN_GET_GROUPS_OF_SPP = "fn_get_groups_of_spp";
        static String FN_LIST = "fn_list";
        static String FN_GET_TREE_FOR_USER = "fn_get_tree_for_user_2022";
        static String FN_REVOKE_FUNCS_OF_USER = "fn_revoke_funcs_of_user";
        static String FN_GRANT_FUNC_TO_USER = "fn_grant_func_to_user";
        static String FN_GET_GROUPS_OF_USER = "fn_get_groups_of_user";
        static String FN_REVOKE_GROUPS_OF_USER = "fn_revoke_groups_of_user";
        static String FN_GRANT_GROUP_TO_USER = "fn_grant_group_to_user";
        static String FN_GET_MENU_BY_MODULE = "fn_get_menu_by_module_2022";
        static String FN_GET_SPPS = "fn_get_spps_2022";
        static String FN_FIND_2022 = "fn_find_2022";
        static String FN_GET_LIST_REPORT = "fn_get_list_report";
        static String FN_REGISTER_NEAR = "fn_register_near";
        static String FN_REGISTER_OVER = "fn_register_over";
        static String FN_GET_LAWGROUPCHAP_2022 = "fn_get_lawgroupchap_2022";
        static String FN_SEARCH_DATE_SPPID = "fn_search_date_sppid";
        static String FN_THULY_MOI_GAI_DOAN = "fn_thuly_moi_gai_doan";
        static String FN_XULY_THULY_MOI_GAI_DOAN = "fn_xuly_thuly_moi_gai_doan";
        static String GET_RPT_COMP_INFO = "get_rpt_comp_info";
        static String FN_THULY_MOI_FDATE_TDATE = "fn_thuly_moi_fdate_tdate";
        static String FN_THULY_MOI_DIEU_LUAT = "fn_thuly_moi_dieu_luat";
        static String FN_THULY_NHOM_VU_AN = "fn_thuly_nhom_vu_an";
        static String GET_CATL_VKSKTL = "get_CATL_VKSKTL";
        static String GET_VKSTL_TAKTL = "get_VKSTL_TAKTL";
        static String GET_RPT_LAW = "GET_RPT_LAW";
        static String GET_RPT_PENALTY = "GET_RPT_PENALTY";
        static String FN_SEARCH_DECI_2022 = "fn_search_deci_2022";
        static String FN_SEARCH_DECI_OVER = "fn_search_deci_over";
        static String FN_SEARCH_DECI_NEAR = "fn_search_deci_near";
        static String FN_SEARCH_DECI_NEAR_TAMGIAM = "fn_search_deci_near_tamgiam";
        static String FN_SEARCH_DECI_OVER_TAMGIAM = "fn_search_deci_over_tamgiam";
        static String FN_MONITORAGAINST = "fn_monitorAgainst";
        static String FN_MONITORAPPEAL = "fn_monitorAppeal";
        static String FN_LOOKUP_LAW = "fn_lookup_law";
        static String FN_LOOKUP_INSPECTOR_DETAILS = "fn_lookup_inspector_details";
        static String FN_LOOKUP_CENTENCE_DETAILS = "fn_lookup_centence_details";
        static String FN_CENTENCE_LISTCENTENCE = "fn_centence_ListCentence";
        static String FN_CENTENCE_LISTCENTLAW = "fn_centence_ListCentLaw";
        static String FN_CENTENCE_LISTSTATISTICC = "fn_centence_ListStatisticc";
        static String FN_CENTENCE_LISTSTATISTICA = "fn_centence_ListStatistica";

        //TAB_ACCUSED
        static String FN_IN_FOR_ACCUSED = "fn_in_for_accused"; //CASE 1
        static String FN_IN_FOR_PROSECUTION = "fn_in_for_prosecution"; //CASE 2
        static String FN_IN_PARTY_ACCUSED = "fn_in_party_accused"; //CASE 3
        static String FN_IN_CATL_VKSKTL = "fn_in_catl_vksktl"; //CASE 4
        static String FN_ACCUSED_VKS_TA = "fn_accused_vks_ta"; //CASE 5
        static String FN_IN_FOR_CASE = "fn_in_for_case";  //CASE 6
        static String FN_ADOLESCENT_ACCUSED= "fn_adolescent_accused"; //CASE 7
        static String FN_IN_VKSTT_TAKTL= "fn_in_vkstt_taktl"; //CASE 8
        static String FN_XXST= "fn_xxst"; //CASE 11
        //TAB TRANSFER
        static String FN_TRANSFER_VKS_CQDT= "fn_transfer_vks_cqdt";
        static String FN_TRANSFER_VKS_VKS= "fn_transfer_vks_vks";
        static String FN_TRANSFER_VKS_TA= "fn_transfer_vks_ta";
        static String DATA_VERIFY= "data_verify";
        static String FN_GET_VERIFIES= "fn_get_verifies";

        //NGHỀ NGHIỆP
        static String FN_GET_ATXOCCUPATION= "fn_get_atxOccupation";
    }

}
