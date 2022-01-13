package com.innerchic.weqiuqiu.emoji;

import java.util.ArrayList;
import java.util.List;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:50
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : 标识一个表情对象
╚════════════════════════════════════════════╝
*/
public class Expression {

    private final String name;

    private final String path;


    //load("file:///android_asset/f003.gif")
    public Expression(String name, String path) {
        if (name == null) name = "";
        this.name = name;
        if (path == null) path = "";
//        path = "file:///android_asset/expression/" + path;
        this.path = path;
    }

    /**
     * 是否是emoji表情,true是,默认false图片表情
     */
    private boolean isEmoji = false;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isEmoji() {
        return isEmoji;
    }

    public void setEmoji(boolean emoji) {
        isEmoji = emoji;
    }

    /**
     * 表情数据对象
     */
    public static class ExpressionData {

        public static final List<Expression> data = new ArrayList<>();

        public static final List<String> keys = new ArrayList<>();

        public static String getPath(String name) {
            if (name == null || "".equals(name)) return "icon_loaderror.png";
            name = name.replace("[", "").replace("]", "");
            if (keys.contains(name)) return data.get(keys.indexOf(name)).getPath();
            return null;
        }

        static {
            data.add(new Expression("微笑", "hehe1.png"));
            data.add(new Expression("撇嘴", "piezui1.png"));
            data.add(new Expression("色", "se1.png"));
            data.add(new Expression("发呆", "fadai1.png"));
            data.add(new Expression("得意", "deyi1.png"));
            data.add(new Expression("流泪", "liulei1.png"));
            data.add(new Expression("害羞", "haixiu1.png"));
            data.add(new Expression("闭嘴", "bizui1.png"));
            data.add(new Expression("睡", "shui1.png"));
            data.add(new Expression("大哭", "daku1.png"));
            data.add(new Expression("尴尬", "ganga1.png"));
            data.add(new Expression("发怒", "fanu1.png"));
            data.add(new Expression("调皮", "tiaopi1.png"));
            data.add(new Expression("呲牙", "ciya1.png"));
            data.add(new Expression("惊讶", "jingya1.png"));
            data.add(new Expression("难过", "nanguo1.png"));
            data.add(new Expression("囧", "jiong1.png"));
            data.add(new Expression("抓狂", "zhuakuang1.png"));
            data.add(new Expression("吐", "tu1.png"));
            data.add(new Expression("偷笑", "touxiao1.png"));
            data.add(new Expression("愉快", "yukuai1.png"));
            data.add(new Expression("白眼", "baiyan1.png"));
            data.add(new Expression("傲慢", "aoman1.png"));
            data.add(new Expression("困", "kun1.png"));
            data.add(new Expression("惊恐", "jingkong1.png"));
            data.add(new Expression("流汗", "liuhan.png"));
            data.add(new Expression("憨笑", "hanxiao1.png"));
            data.add(new Expression("悠闲", "youxian1.png"));
            data.add(new Expression("奋斗", "fendou.png"));
            data.add(new Expression("咒骂", "zhouma1.png"));
            data.add(new Expression("疑问", "yiwen1.png"));
            data.add(new Expression("嘘", "xu1.png"));
            data.add(new Expression("晕", "yun1.png"));
            data.add(new Expression("衰", "sui1.png"));
            data.add(new Expression("骷髅", "kulou1.png"));
            data.add(new Expression("敲打", "qiaoda1.png"));
            data.add(new Expression("再见", "zaininmadejian1.png"));
            data.add(new Expression("擦汗", "cahan.png"));
            data.add(new Expression("抠鼻", "koubi1.png"));
            data.add(new Expression("鼓掌", "guzhang.png"));
            data.add(new Expression("坏笑", "huaixiao1.png"));
            data.add(new Expression("左哼哼", "zuohengheng.png"));
            data.add(new Expression("右哼哼", "youhengheng1.png"));
            data.add(new Expression("哈欠", "haqian.png"));
            data.add(new Expression("鄙视", "bishi1.png"));
            data.add(new Expression("委屈", "weiqu1.png"));
            data.add(new Expression("快哭了", "kuaikule1.png"));
            data.add(new Expression("阴险", "yinxian1.png"));
            data.add(new Expression("亲亲", "qinqin1.png"));
            data.add(new Expression("可怜", "kelian1.png"));
            data.add(new Expression("菜刀", "caidao1.png"));
            data.add(new Expression("西瓜", "xigua.png"));
            data.add(new Expression("啤酒", "pijiu1.png"));
            data.add(new Expression("咖啡", "kafei1.png"));
            data.add(new Expression("猪头", "zhutou1.png"));
            data.add(new Expression("玫瑰", "meigui1.png"));
            data.add(new Expression("凋谢", "diaoxie1.png"));
            data.add(new Expression("嘴唇", "zuichun1.png"));
            data.add(new Expression("爱心", "aixin1.png"));
            data.add(new Expression("心碎", "xinsui1.png"));
            data.add(new Expression("蛋糕", "dangao1.png"));
            data.add(new Expression("炸弹", "zhadan1.png"));
            data.add(new Expression("便便", "bianbian1.png"));
            data.add(new Expression("月亮", "yueliang1.png"));
            data.add(new Expression("太阳", "taiyang1.png"));
            data.add(new Expression("拥抱", "yongbao1.png"));
            data.add(new Expression("强", "qiang1.png"));
            data.add(new Expression("弱", "ruo1.png"));
            data.add(new Expression("握手", "woshou1.png"));
            data.add(new Expression("胜利", "shengli1.png"));
            data.add(new Expression("抱拳", "baoquan1.png"));
            data.add(new Expression("勾引", "gouyin1.png"));
            data.add(new Expression("拳头", "quantou.1png"));
            data.add(new Expression("OK", "ok1.png"));
            data.add(new Expression("跳跳", "tiaotiao1.png"));
            data.add(new Expression("发抖", "fadou1.png"));
            data.add(new Expression("怄火", "ohuo.png"));
            data.add(new Expression("转圈", "zhuanquan1.png"));
            data.add(new Expression("嘿哈", "heiha.png"));
            data.add(new Expression("捂脸", "wulian.png"));
            data.add(new Expression("奸笑", "jianxiao.png"));
            data.add(new Expression("机智", "jizhi.png"));
            data.add(new Expression("皱眉", "zhoumei.png"));
            data.add(new Expression("耶", "ye.png"));
            data.add(new Expression("蜡烛", "lazhu.png"));
            data.add(new Expression("红包", "hongbao.png"));
            data.add(new Expression("吃瓜", "chigua.png"));
            data.add(new Expression("加油", "jiayou.png"));
            data.add(new Expression("汗", "han.png"));
            data.add(new Expression("天啊", "tiana.png"));
            data.add(new Expression("Emm", "emm.png"));
            data.add(new Expression("社会社会", "shehuishehui.png"));
            data.add(new Expression("旺柴", "wangchai.png"));
            data.add(new Expression("好的", "haode.png"));
            data.add(new Expression("打脸", "dalian.png"));
            data.add(new Expression("加油加油", "jiayoujiayou.png"));
            data.add(new Expression("哇", "wa.png"));
            data.add(new Expression("發", "fa.png"));
            data.add(new Expression("福", "fu.png"));
            data.add(new Expression("鸡", "ji.png"));

            //收集所有的keys
            for (Expression datum : data) {
                keys.add(datum.name);
            }
        }
    }

}
