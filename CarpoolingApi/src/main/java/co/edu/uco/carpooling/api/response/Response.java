package co.edu.uco.carpooling.api.response;

import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.crosscutting.util.UtilObject;

import java.util.ArrayList;
import java.util.List;

public class Response<D> {
    private List<D> data;
    private List<Message> message;

    public void addMessage(final Message message ) {
        if(!UtilObject.getUtilObject().isNull(message)) {
            getMessage().add(message);
        }

    }
    public void addData(final D data ) {
        if(!UtilObject.getUtilObject().isNull(data)) {
            getData().add(data);
        }

    }

    public List<D> getData() {
        if(UtilObject.getUtilObject().isNull(data)) {
            this.data = new ArrayList<>();
        }
        return data;
    }

    public void setData(List<D> data) {
        this.data = UtilObject.getUtilObject().getDefaultIsNull(data, new ArrayList<>());
    }

    public List<Message> getMessage() {
        if(UtilObject.getUtilObject().isNull(message)) {
            this.message = new ArrayList<>();
        }
        return message;
    }

    public void setMessage(List<Message> messages) {
        this.message = UtilObject.getUtilObject().getDefaultIsNull(messages, new ArrayList<>());
    }

}
