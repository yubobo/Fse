package com.jfireframework.fse.serializer.extra;

import com.jfireframework.fse.*;

import java.sql.Date;

public class SqlDateSerializer extends CycleFlagSerializer implements FseSerializer
{
    @Override
    public void init(Class<?> type, SerializerFactory serializerFactory)
    {
    }

    @Override
    public void writeToBytes(Object o, int classIndex, InternalByteArray byteArray, FseContext fseContext, int depth)
    {
        byteArray.writeVarInt(classIndex);
        long time = ((Date) o).getTime();
        byteArray.writeVarLong(time);
    }

    @Override
    public Object readBytes(InternalByteArray byteArray, FseContext fseContext)
    {
        long l    = byteArray.readVarLong();
        Date date = new Date(l);
        return date;
    }
}
