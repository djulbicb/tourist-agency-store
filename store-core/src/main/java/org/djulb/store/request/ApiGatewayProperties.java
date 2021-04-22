package org.djulb.store.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@ConfigurationProperties(prefix = "api.gateway")
public class ApiGatewayProperties {

    private List<Endpoint> endpoints;

    public static class Endpoint {
        private String path;
        private RequestMethod method;
        private String location;
        private String port;
        private String username;
        private String password;

        public Endpoint() {
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public Endpoint(String location) {
            this.location = location;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public RequestMethod getMethod() {
            return method;
        }

        public void setMethod(RequestMethod method) {
            this.method = method;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Endpoint{" +
                    "path='" + path + '\'' +
                    ", method=" + method +
                    ", location='" + location + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    @Override
    public String toString() {
        return "ApiGatewayProperties{" +
                "endpoints=" + endpoints +
                '}';
    }
}
