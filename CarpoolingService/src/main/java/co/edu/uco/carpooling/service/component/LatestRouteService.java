package co.edu.uco.carpooling.service.component;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import org.springframework.stereotype.Component;

@Component
public class LatestRouteService {

    private RouteDomain latestRoute;

    public void setLatestRoute(RouteDomain route) {
        latestRoute = route;
    }

    public RouteDomain getLatestRoute() {
        return latestRoute;
    }
}
