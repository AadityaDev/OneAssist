package com.technawabs.oneassist.services;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.common.util.concurrent.ListenableFuture;
import com.technawabs.oneassist.Utility;
import com.technawabs.oneassist.concurrency.ExecutorUtils;
import com.technawabs.oneassist.constants.AppAPI;
import com.technawabs.oneassist.network.RequestGenerator;
import com.technawabs.oneassist.network.RequestHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.Callable;

import okhttp3.Request;

public class JobService {

    public ListenableFuture<JSONArray> getRecommendedJobs(@NonNull final String token, @NonNull final int pageNumber,
                                                          final int pageSize) {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.RECOMMENDED_JOBS_FOR_ME +
                        "?pageNumber=" + pageNumber + "&pageSize=" + pageSize, token);
                String body = RequestHandler.makeRequestAndValidate(request);
                JSONArray jsonArray = Utility.getResultJSONArray(body);
                return jsonArray;
            }
        });
    }

    public ListenableFuture<JSONArray> getRecommendedJobsForFriend(@NonNull final String token, @NonNull final int pageNumber,
                                                                   final int pageSize, final String email) {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.RECOMMENDED_JOBS_FOR_FRIEND + email +
                        "&pageNumber=" + pageNumber + "&pageSize=" + pageSize, token);
                String body = RequestHandler.makeRequestAndValidate(request);
                JSONArray jsonArray = Utility.getResultJSONArray(body);
                return jsonArray;
            }
        });
    }

    public ListenableFuture<JSONArray> getJobsForFriends(@NonNull final String token, @NonNull final int pageNumber,
                                                         final int pageSize) {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.RECOMMENDED_JOBS_FOR_FRIENDS + AppAPI.JobsFor.FOR_MY_FRIENDS +
                        "&pageNumber=" + pageNumber + "&pageSize=" + pageSize, token);
                String body = RequestHandler.makeRequestAndValidate(request);
                JSONArray jsonArray = Utility.getResultJSONArray(body);
                return jsonArray;
            }
        });
    }

    public ListenableFuture<JSONArray> getJobsBySkillOrIndustry(@NonNull final String searchText, @NonNull final int pageNumber,
                                                                final int pageSize) {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.JOBS_SKILL_OR_INDUSTRY_BASED + searchText +
                        "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
                String body = RequestHandler.makeRequestAndValidate(request);
                JSONArray jsonArray = Utility.getResultJSONArray(body);
                return jsonArray;
            }
        });
    }

    public ListenableFuture<JSONObject> getJobById(@NonNull final long jobId) {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.JOB_DETAIL + jobId);
                String body = RequestHandler.makeRequestAndValidate(request);
                Log.d("JobService",body);
                JSONObject result = Utility.getResultJSONObject(body);
                return result;
            }
        });
    }
}
