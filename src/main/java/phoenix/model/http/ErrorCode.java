package phoenix.model.http;

public enum ErrorCode {
    MALFORMED_URL(900, "Request URL is malformed"),
    PROTOCOL_ERROR(901, "Protocol error"),
    TIMEOUT(998, "Requested server did not respond"),
    UNKNOWN(999, "UNKNOWN Error");

    private String message;
    private final int code;

    ErrorCode(int errorCode, String message) {
        this.message = message;
        this.code = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}