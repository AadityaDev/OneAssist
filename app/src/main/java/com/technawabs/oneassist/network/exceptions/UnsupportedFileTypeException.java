package com.technawabs.oneassist.network.exceptions;

import com.technawabs.oneassist.constants.AppConstants;

public class UnsupportedFileTypeException extends HttpException {

    public UnsupportedFileTypeException() {
        super(AppConstants.MESSAGE_UNSUPPORTED_FILE_TYPE);
    }

}
