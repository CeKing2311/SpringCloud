package com.ceking.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *@author ceking
 *@description 编码方式实现路由网关配置
 *@date 2021-1-25 17:11
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_ceking",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder locatorBuilder) {
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_ceking2",
                r -> r.path("/ent")
                        .uri("http://news.baidu.com/ent")).build();
        return routes.build();
    }
}
