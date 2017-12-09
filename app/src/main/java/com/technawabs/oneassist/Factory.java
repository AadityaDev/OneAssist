package com.technawabs.oneassist;

import android.content.Context;
import android.os.StrictMode;

import com.google.android.gms.common.api.GoogleApiClient;
import com.technawabs.oneassist.services.JobService;

import net.jcip.annotations.GuardedBy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Factory {
    private static final Object LOCK = new Object();
    public static final int TIMEOUT_IN_SECONDS = 60;

    @GuardedBy("LOCK")
    private static OkHttpClient mOkHttpClient;
//    @GuardedBy("LOCK")
//    private static FCMRegistrationService mFcmRegistrationService;
    @GuardedBy("LOCK")
    private static JobService mJobService;
//    @GuardedBy("LOCK")
//    private static SkillScoreService mSkillScoreService;
//    @GuardedBy("LOCK")
//    private static ConnectionSuggestionService mConnectionSuggestionService;
//    @GuardedBy("LOCK")
//    private static SearchService mSearchService;
//    @GuardedBy("LOCK")
//    private static LeaderBoardService mLeaderBoardService;
//    @GuardedBy("LOCK")
//    private static CandidateService mCandidateService;
//    @GuardedBy("LOCK")
//    private static NotificationService mNotificationService;
//    @GuardedBy("LOCK")
//    private static WalletService mWalletService;
//    @GuardedBy("LOCK")
//    private static ConnectionService mConnectionService;
//    @GuardedBy("LOCK")
//    private static GCMService mGcmService;
//    @GuardedBy("LOCK")
//    private static JobApplicationService mJobApplicationService;
//    @GuardedBy("LOCK")
//    private static AppUpdateService mAppUpdateService;
    @GuardedBy("LOCK")
    private static GoogleApiClient mGoogleApiClientService;

//    public static FCMRegistrationService getFcmRegistrationService() {
//        synchronized (LOCK) {
//            if (mFcmRegistrationService == null) {
//                mFcmRegistrationService = new FCMRegistrationService();
//            }
//        }
//        return mFcmRegistrationService;
//    }
//
//    public static GCMService getGcmService() {
//        synchronized (LOCK) {
//            if (mGcmService == null) {
//                mGcmService = new GCMService();
//            }
//            return mGcmService;
//        }
//    }

    public static OkHttpClient getOkHTTPClient() {
        synchronized (LOCK) {
            if (mOkHttpClient == null) {
                mOkHttpClient = new OkHttpClient.Builder()
                        .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .build();
            }
        }
        return mOkHttpClient;
    }

    public static void setUpThreadPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

//    public static JobService getJobService() {
//        synchronized (LOCK) {
//            if (mJobService == null) {
//                mJobService = new JobService();
//            }
//        }
//        return mJobService;
//    }
//
//    public static ConnectionSuggestionService getConnectionSuggestionService() {
//        synchronized (LOCK) {
//            if (mConnectionSuggestionService == null) {
//                mConnectionSuggestionService = new ConnectionSuggestionService();
//            }
//        }
//        return mConnectionSuggestionService;
//    }
//
//    public static SkillScoreService getSkillScoreService() {
//        synchronized (LOCK) {
//            if (mSkillScoreService == null) {
//                mSkillScoreService = new SkillScoreService();
//            }
//        }
//        return mSkillScoreService;
//    }
//
//    public static SearchService getSearchService() {
//        synchronized (LOCK) {
//            if (mSearchService == null) {
//                mSearchService = new SearchService();
//            }
//        }
//        return mSearchService;
//    }
//
//    public static LeaderBoardService getLeaderBoardService() {
//        synchronized (LOCK) {
//            if (mLeaderBoardService == null) {
//                mLeaderBoardService = new LeaderBoardService();
//            }
//        }
//        return mLeaderBoardService;
//    }
//
//    public static CandidateService getCandidateService() {
//        synchronized (LOCK) {
//            if (mCandidateService == null) {
//                mCandidateService = new CandidateService();
//            }
//        }
//        return mCandidateService;
//    }
//
//    public static NotificationService getNotificationService() {
//        synchronized (LOCK) {
//            if (mNotificationService == null) {
//                mNotificationService = new NotificationService();
//            }
//        }
//        return mNotificationService;
//    }
//
//    public static WalletService getWalletService() {
//        synchronized (LOCK) {
//            if (mWalletService == null) {
//                mWalletService = new WalletService();
//            }
//        }
//        return mWalletService;
//    }
//
//    public static ConnectionService getConnectionService() {
//        synchronized (LOCK) {
//            if (mConnectionService == null) {
//                mConnectionService = new ConnectionService();
//            }
//        }
//        return mConnectionService;
//    }
//
//    public static JobApplicationService getJobApplicationService() {
//        synchronized (LOCK) {
//            if (mJobApplicationService == null) {
//                mJobApplicationService = new JobApplicationService();
//            }
//        }
//        return mJobApplicationService;
//    }
//
//    public static AppUpdateService getAppUpdateService() {
//        synchronized (LOCK) {
//            if (mAppUpdateService == null) {
//                mAppUpdateService = new AppUpdateService();
//            }
//        }
//        return mAppUpdateService;
//    }

//    public static GoogleApiClient getGoogleApiClientService(Context context) {
//        synchronized (LOCK) {
//            if (mGoogleApiClientService == null) {
//                mGoogleApiClientService = new GoogleApiClient.Builder(context).addApi(AppIndex.API).build();
//            }
//        }
//        return mGoogleApiClientService;
//    }
}
