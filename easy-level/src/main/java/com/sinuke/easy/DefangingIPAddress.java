package com.sinuke.easy;

public class DefangingIPAddress {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}
