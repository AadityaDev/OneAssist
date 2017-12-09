package com.technawabs.oneassist.network.exceptions;

import com.technawabs.oneassist.constants.AppConstants;

public class UnauthorizedAccessException extends HttpException {

    public UnauthorizedAccessException() {
        super(AppConstants.UNAUTHORIZED_ACCESS);
    }
}
