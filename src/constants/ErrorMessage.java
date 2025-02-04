package constants;

public enum ErrorMessage {
    WRONG_NUMBER("올바른 번호를 입력하세요!"),
    LACK_WATTAGE("파워의 전력 요구량이 부족합니다! 다시 선택해주세요.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
