package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.MessageDao;
import museum_management_system.Storage.Model.Message;

import java.util.List;

public class MessageService {

    public List<Message> save(Message message) {
        MessageDao messageDao = new MessageDao();
        messageDao.InsertMessage(message);
        return messageDao.GetMessages();
    }

    public List<Message> delete(int message_id) {
        MessageDao messageDao = new MessageDao();
        messageDao.DeleteMessage(message_id);
        return messageDao.GetMessages();
    }

    public List<Message> update(Message message) {
        MessageDao messageDao = new MessageDao();
        messageDao.UpdateMessage(message);
        return messageDao.GetMessages();
    }

    public List<Message> get() {
        MessageDao messageDao = new MessageDao();
        return messageDao.GetMessages();
    }
}
