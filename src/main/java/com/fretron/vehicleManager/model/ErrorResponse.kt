package com.fretron.vehicleManager.model

class ErrorResponse(
    private var errorCode: String?,
    private var errorMessage: String?,
    private var timeStamp: String?,
    private var exception: String?
) {

    constructor() : this(null, null, null, null)

    override fun toString(): String {
        return "ErrorResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", exception='" + exception + '\'' +
                '}'
    }

    fun setErrorCode(errorCode: String?) {
        this.errorCode = errorCode
    }

    fun getErrorCode() = this.errorCode

    fun setTimeStamp() {
        this.timeStamp
    }

    fun getTimeStamp() = this.timeStamp

    fun setErrorMessage(errorMessage: String?) {
        this.errorMessage = errorMessage
    }

    fun getErrorMessage() = this.errorMessage

    fun setException(exception: String?) {
        this.exception = exception
    }

    fun getException() = this.exception

}