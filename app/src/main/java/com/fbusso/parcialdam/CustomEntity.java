package com.fbusso.parcialdam;

import androidx.annotation.NonNull;

public class CustomEntity {
    int _id;
    String _value;

    public CustomEntity() {

    }

    public CustomEntity(String _value) {
        this._value = _value;
    }


    public CustomEntity(int _id, String _value) {
        this._id = _id;
        this._value = _value;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: ".concat(String.valueOf(this._id)).concat(" - Valor: ").concat(this._value);
    }
}
