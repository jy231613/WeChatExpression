# WeChatExpression
微信表情;聊天表情发送;

详情见CSDN:https://blog.csdn.net/qq_36676433/article/details/104756685

2022年01月13日:更新了部分微信表情,在更新文件的后面添加了1的均为新表情,使用时更改配置文件即可.

上传了一版同样的java代码,便于在java中使用



java使用时不要.dart文件,Flutter使用时不要emoji文件夹和oldbase的文件夹.

Java使用方法:



    <com.innerchic.weqiuqiu.emoji.EmojiView
        android:id="@+id/emojiView"
        android:layout_width="match_parent"
        android:layout_height="220dp"
        android:layout_marginTop="10dp"/>
       
       
监听:
       

    holder.emojiView.setEmojiListener(new OnClickEmojiListener() {
            @Override
            public void onClick(Expression expression, int pos) {
                Editable text = holder.edtextContent.getText();
                if (text == null || "".equals(text.toString())) {
                    holder.edtextContent.append("[" + expression.getName() + "]");
                    return;
                }
                int index = holder.edtextContent.getSelectionStart();
                text.insert(index, "[" + expression.getName() + "]");
            }

            @Override
            public void onLongClick(Expression expression, int pos) {
                showToast(expression.getName());
            }
        });
