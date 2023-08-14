package co.edu.uco.carpooling.api.response.dto;

import co.edu.uco.carpooling.api.response.enumeration.MessageLevel;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;

public class Message {
    private String text;
    private String title;
    private MessageLevel level;

    private Message(String text, String title, MessageLevel level) {
        setText(text);
        setTitle(title);
        setLevel(level);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(UtilObject.getUtilObject().isNull(text) || UtilText.EMPTY.intern().equals(UtilText.getUtilText().trim(text))) {
            this.text = UtilText.EMPTY;
        } else {
            this.text = UtilText.getUtilText().trim(text);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (UtilObject.getUtilObject().isNull(title) || UtilText.EMPTY.intern().equals(UtilText.getUtilText().trim(title))) {
            this.title = UtilText.EMPTY;
        } else {
            this.title = UtilText.getUtilText().trim(title);
        }
    }

    public MessageLevel getLevel() {
        return level;
    }

    public void setLevel(MessageLevel level) {
        if(UtilObject.getUtilObject().isNull(level)) {
            this.level = MessageLevel.FATAL;
        } else {
            this.level = level;
        }
    }
}
