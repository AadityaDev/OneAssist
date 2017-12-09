package com.technawabs.oneassist.network.exceptions;

import com.technawabs.oneassist.constants.AppConstants;

public class ServerErrorException extends HttpException {

    public ServerErrorException() {
        super(AppConstants.MESSAGE_SERVER_ERROR);
    }
}
