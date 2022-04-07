package me.dartanman.extrassentials.chat.utils;

import me.dartanman.extrassentials.core.players.EPlayer;

import java.util.HashMap;

public class ChatUtils
{

    private static HashMap<EPlayer, EPlayer> replyMap;

    public static void setReplyTo(EPlayer originalSender, EPlayer replier)
    {
        if(replyMap.containsKey(replier))
        {
            replyMap.remove(replier);
        }
        replyMap.put(replier, originalSender);
    }

    public static EPlayer getReplyTo(EPlayer replier)
    {
        if(replyMap.containsKey(replier))
        {
            return replyMap.get(replier);
        }
        else
        {
            return null;
        }
    }

}
