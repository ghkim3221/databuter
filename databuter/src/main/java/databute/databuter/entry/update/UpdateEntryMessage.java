package databute.databuter.entry.update;

import com.google.common.base.MoreObjects;
import databute.databuter.entry.EntryMessage;
import databute.databuter.entry.EntryValueType;
import databute.network.message.MessageCode;

import static com.google.common.base.Preconditions.checkNotNull;

public class UpdateEntryMessage implements EntryMessage {

    private final String id;
    private final String key;
    private final EntryValueType valueType;
    private final Object value;

    public UpdateEntryMessage(String id, String key, EntryValueType valueType, Object value) {
        this.id = checkNotNull(id, "id");
        this.key = checkNotNull(key, "key");
        this.valueType = checkNotNull(valueType, "valueType");
        this.value = checkNotNull(value, "value");
    }

    @Override
    public MessageCode messageCode() {
        return MessageCode.UPDATE_ENTRY;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String key() {
        return key;
    }

    public EntryValueType valueType() {
        return valueType;
    }

    public Object value() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("messageCode", messageCode())
                .add("id", id)
                .add("key", key)
                .add("valueType", valueType)
                .add("value", value)
                .toString();
    }
}
