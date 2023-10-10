package co.edu.uco.carpooling.service.port.broker.route;

import co.edu.uco.carpooling.service.domain.requestroute.RouteRequestDomain;
import co.edu.uco.carpooling.service.port.broker.MessageSenderPort;

public interface SenderRouteRequestPort extends MessageSenderPort<RouteRequestDomain> {
}
