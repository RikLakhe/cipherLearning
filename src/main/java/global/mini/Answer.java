package global.mini;

public class Answer {
    private String answer;
    private int key;

    public Answer(String encryptDecrypt, int key) {
        this.answer = encryptDecrypt;
        this.key = key;
    }

    public String getAnswer() {
        return answer;
    }

    public int getKey() {
        return 26-key;
    }
}
