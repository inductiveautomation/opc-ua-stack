package com.digitalpetri.opcua.stack.core.types.enumerated;

import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEnumeration;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum MessageSecurityMode implements UaEnumeration {

    Invalid(0),
    None(1),
    Sign(2),
    SignAndEncrypt(3);

    private final int value;

    private MessageSecurityMode(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    private static final ImmutableMap<Integer, MessageSecurityMode> VALUES;

    static {
        Builder<Integer, MessageSecurityMode> builder = ImmutableMap.builder();
        for (MessageSecurityMode e : values()) {
            builder.put(e.getValue(), e);
        }
        VALUES = builder.build();
    }

    public static MessageSecurityMode from(Integer value) {
        if (value == null) return null;
        return VALUES.getOrDefault(value, null);
    }

    public static void encode(MessageSecurityMode messageSecurityMode, UaEncoder encoder) {
        encoder.encodeInt32(null, messageSecurityMode.getValue());
    }

    public static MessageSecurityMode decode(UaDecoder decoder) {
        int value = decoder.decodeInt32(null);

        return VALUES.getOrDefault(value, null);
    }

    static {
        DelegateRegistry.registerEncoder(MessageSecurityMode::encode, MessageSecurityMode.class);
        DelegateRegistry.registerDecoder(MessageSecurityMode::decode, MessageSecurityMode.class);
    }

}
