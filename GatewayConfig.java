@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Employee-MicroService", r -> r
                        .path("/api/employee/**")
                        .uri("http://localhost:8082"))
                .route("Address-MicroService", r -> r
                        .path("/api/address", "/api/addresses", "/api/employee/{empId}")
                        .uri("http://localhost:8081"))
                .build();
    }
}
