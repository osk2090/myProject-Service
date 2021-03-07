package com.osk2090.edit_ver.draw.util;

public interface ObjectFactory<T> {
    T create(String csvstr);
}
