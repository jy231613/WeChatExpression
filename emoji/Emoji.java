package com.innerchic.weqiuqiu.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:01
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : 表情解析库
╚════════════════════════════════════════════╝
*/
public class Emoji {

    /**
     * 解码
     */
    public static SpannableString decode(Context context, String msg) {
        SpannableString spannableString = new SpannableString(msg);
        Pattern compile = Pattern.compile("\\[.{1,4}?]");
        Matcher matcher = compile.matcher(msg);
        while (matcher.find()) {
            try {
                String path = Expression.ExpressionData.getPath(matcher.group());
                if (path == null) continue;//为null时跳过
                String imgPath = "expression/" + path;
                InputStream ims = context.getAssets().open(imgPath);
                Drawable fromStream = Drawable.createFromStream(ims, null);
                fromStream.setBounds(0, 0, 50, 50);
                ImageSpan imageSpan = new ImageSpan(fromStream, ImageSpan.ALIGN_BASELINE);
                spannableString.setSpan(imageSpan, matcher.start(), matcher.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return spannableString;
    }

}