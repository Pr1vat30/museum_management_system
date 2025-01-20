package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.MessageDao;
import museum_management_system.Storage.Model.Message;

import java.util.List;
import java.util.Map;

public class EventService {

    public List<Message> save(Map<String, Object> jsonMap) {
        Message message = new Message(
                (String) jsonMap.get("title"),
                (String) jsonMap.get("object"),
                (String) jsonMap.get("content")
        );
        MessageDao messageDao = new MessageDao();
        messageDao.InsertMessage(message);
        return messageDao.GetMessages();
    }

    public List<Message> delete(int message_id) {
        MessageDao messageDao = new MessageDao();
        messageDao.DeleteMessage(message_id);
        return messageDao.GetMessages();
    }

    public List<Message> update(Map<String, Object> jsonMap) {
        Message message = new Message(
                (String) jsonMap.get("title"),
                (String) jsonMap.get("object"),
                (String) jsonMap.get("content")
        );
        message.setMessage_id(Integer.parseInt((String) jsonMap.get("message_id")));
        MessageDao messageDao = new MessageDao();
        messageDao.UpdateMessage(message);
        return messageDao.GetMessages();
    }

    public List<Message> get() {
        MessageDao messageDao = new MessageDao();
        return messageDao.GetMessages();
    }
}
