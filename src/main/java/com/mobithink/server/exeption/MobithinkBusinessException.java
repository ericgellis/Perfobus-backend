package com.mobithink.server.exeption;

/**
 * Created by athiel on 02/02/2017.
 */
public class MobithinkBusinessException extends Exception {

    private static final long serialVersionUID = 3161147448578705806L;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public MobithinkBusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public MobithinkBusinessException() {
        super();
    }

}
