package com.technawabs.oneassist.network.exceptions;

import com.technawabs.oneassist.constants.AppConstants;

public class AccessDeniedException extends HttpException {
    public AccessDeniedException() {
        super(AppConstants.ACCESS_DENIED);
    }
}
