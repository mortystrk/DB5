package hash;

/**
 * Created by Danila on 30.09.2017.
 */

public class Item {

    private String key;
    private String message;

    public Item(String key, String message)
    {
        this.key = key;
        this.message = message;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
