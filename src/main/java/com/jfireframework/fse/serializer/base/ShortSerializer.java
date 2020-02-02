package com.jfireframework.fse.serializer.base;

import com.jfireframework.fse.*;

public class ShortSerializer extends CycleFlagSerializer implements FseSerializer
{
    @Override
    public void init(Class<?> type, SerializerFactory serializerFactory)
    {
    }

    @Override
    public void writeToBytes(Object o, int classIndex, InternalByteArray byteArray, FseContext fseContext, int depth)
    {
        byteArray.writeVarInt(classIndex);
        byteArray.writeShort((Short) o);
    }

    @Override
    public Object readBytes(InternalByteArray byteArray, FseContext fseContext)
    {
        return byteArray.readShort();
    }

    @Override
    public void writeToBytesWithoutRegisterClass(Object o, InternalByteArray byteArray, FseContext fseContext, int depth)
    {
        if (o == null)
        {
            byteArray.put((byte) 0);
            return;
        }
        byteArray.put((byte) 1);
        byteArray.writeShort((Short) o);
    }

    @Override
    public Object readBytesWithoutRegisterClass(InternalByteArray byteArray, FseContext fseContext)
    {
        if (byteArray.get() == 0)
        {
            return null;
        }
        return byteArray.readShort();
    }
}