package com.technawabs.oneassist.constants;

public class AppAPI {

    public static final String SERVER_BASE_HOME = "http://myrefers.com/myrefers-api/";

    public class Headers {
        public static final String ACCEPT_KEY = "Accept";
        public static final String ACCEPT_VALUE = "application/vnd.myrefers.v0+json";
        public static final String ACCEPT_JSON = "application/json";
        public static final String AUTHORIZATION_KEY = "Authorization";
        public static final String CAN_RENDER_HTML = "X-HTML-CanRender";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String MYREFERS_PLATFORM = "MYREFERS_PLATFORM";
        public static final String MYREFERS_PLATFORM_ANDROID = "android";
    }

    public static final String JOB_DETAIL = SERVER_BASE_HOME + "jobs/";
    public static final String JOBS_SKILL_OR_INDUSTRY_BASED = SERVER_BASE_HOME + "jobs" + "?skillIndustry=";
    public static final String RECOMMENDED_JOBS_FOR_ME = SERVER_BASE_HOME + "candidates/jobs-recommendations";
    public static final String RECOMMENDED_JOBS_FOR_FRIENDS = SERVER_BASE_HOME + "candidates/jobs-recommendations?forWhom=";
    public static final String RECOMMENDED_JOBS_FOR_FRIEND = SERVER_BASE_HOME + "candidates/jobs-recommendations?candidateEmail=";

    public class JobsFor {
        public static final String FOR_ME = "forMe";
        public static final String FOR_MY_FRIENDS = "forMyFriends";
    }

}
