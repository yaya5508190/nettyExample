package time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * Created by 35737 on 2016/2/13.
 */
public class TimeEncoder extends ChannelHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime unixTime = (UnixTime) msg;
        ByteBuf encode = ctx.alloc().buffer(4);
        encode.writeInt(unixTime.getValue());
        ctx.write(encode, promise);
    }
}
