package com.fretron.vehicleManager.model

class ErrorResponse {
    private var errorCode: String? = null
    private var errorMessage: String? = null
    private var timeStamp: String? = null
    private var exception: String? = null

    constructor()

    constructor(errorCode: String?, errorMessage: String?, timeStamp: String?, exception: String?) {
        this.errorCode = errorCode
        this.errorMessage = errorMessage
        this.timeStamp = timeStamp
        this.exception = exception
    }

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