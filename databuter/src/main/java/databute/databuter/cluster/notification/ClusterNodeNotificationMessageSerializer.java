package databute.databuter.cluster.notification;

import databute.network.message.MessageSerializer;
import databute.network.packet.BufferedPacket;
import databute.network.packet.Packet;

import static com.google.common.base.Preconditions.checkNotNull;

public class ClusterNodeNotificationMessageSerializer implements MessageSerializer<ClusterNodeNotificationMessage> {

    @Override
    public Packet serialize(ClusterNodeNotificationMessage clusterNodeNotificationMessage) {
        checkNotNull(clusterNodeNotificationMessage, "clusterNodeNotificationMessage");

        final Packet packet = new BufferedPacket();
        packet.writeString(clusterNodeNotificationMessage.type().name());
        packet.writeString(clusterNodeNotificationMessage.id());
        packet.writeString(clusterNodeNotificationMessage.endpoint().address());
        packet.writeInt(clusterNodeNotificationMessage.endpoint().port());
        return packet;
    }
}
