package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.Identifiers;
import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaStructure;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;

@UaDataType("RelativePath")
public class RelativePath implements UaStructure {

    public static final NodeId TypeId = Identifiers.RelativePath;
    public static final NodeId BinaryEncodingId = Identifiers.RelativePath_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.RelativePath_Encoding_DefaultXml;

    protected final RelativePathElement[] _elements;

    public RelativePath() {
        this._elements = null;
    }

    public RelativePath(RelativePathElement[] _elements) {
        this._elements = _elements;
    }

    public RelativePathElement[] getElements() {
        return _elements;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(RelativePath relativePath, UaEncoder encoder) {
        encoder.encodeArray("Elements", relativePath._elements, encoder::encodeSerializable);
    }

    public static RelativePath decode(UaDecoder decoder) {
        RelativePathElement[] _elements = decoder.decodeArray("Elements", decoder::decodeSerializable, RelativePathElement.class);

        return new RelativePath(_elements);
    }

    static {
        DelegateRegistry.registerEncoder(RelativePath::encode, RelativePath.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(RelativePath::decode, RelativePath.class, BinaryEncodingId, XmlEncodingId);
    }

}
