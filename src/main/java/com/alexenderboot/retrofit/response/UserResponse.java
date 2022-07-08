package com.alexenderboot.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UserResponse {
    @ToString
    @Setter
    @Getter
    public static class Address{
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;
    }
    @ToString
    @Setter
    @Getter
    public static class Company{
        public String name;
        public String catchPhrase;
        public String bs;
    }
    @ToString
    @Setter
    @Getter
    public static class Geo{
        public String lat;
        public String lng;
    }
        public int id;
        public String name;
        public String username;
        public String email;
        public Address address;
        public String phone;
        public String website;
        public Company company;
}
