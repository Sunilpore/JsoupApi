package com.mydesign.utils.network;

public class ServerResponse {

    public interface Code {
        public static final short OK = 200;
        public static final short BAD_REQUEST = 400;
        public static final short NO_CONTENT = 204;
        public static final short UN_PROCESSABLE = 422;
        public static final short AUTHORIZATION_TOKEN_NOT_PROVIDED = 401;
        public static final short FORBIDDEN_REQUEST = 403;
        public static final short NOT_FOUND = 404;
        public static final short NOT_ACCEPTABLE = 406;
        public static final short REQUEST_TIMEOUT = 408;
        public static final short GONE = 410;
        public static final short TOO_MANY_REQUESTS = 429;

        public static final short INTERNAL_SERVER_ERROR = 500;
        public static final short NOT_IMPLEMENTED_ON_SERVER = 501;
        public static final short BAD_GATEWAY = 502;
        public static final short SERVICE_UNAVAILABLE = 503;
        public static final short GATEWAY_TIMEOUT = 504;
    }
}
